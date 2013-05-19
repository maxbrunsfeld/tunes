(ns app.audio.player
  (:use [app.audio.base :only (*audio-context* main-output)])
  (:require [app.audio.wave-tables :as wave-tables]))

(defn now [] (.-currentTime *audio-context*))

(defn make-voice []
  (let
    [oscillator (.createOscillator *audio-context*)
     amp (.createGain *audio-context*)]
    (.connect amp main-output)
    (set! (.-value (.-gain amp)) 0)
    (.start oscillator 0)
    (.connect oscillator amp)
    (.setWaveTable oscillator (wave-tables/major))
    {:oscillator oscillator :amp amp}))

(defn play-tone [voice pitch]
  (set! (.-value (.-frequency (:oscillator voice))) pitch)
  (doto (.-gain (:amp voice))
    (.cancelScheduledValues (now))
    (.linearRampToValueAtTime 0.8 (+ (now) 0.05))
    (.linearRampToValueAtTime 0.0 (+ (now) 0.6))))

(def pitches
  {"C" 200
   "F" 180
   "G" 220
   })

(def top-voice (make-voice))

(defn play-chord [chord-name]
  (.log js/console (play-tone top-voice (pitches chord-name)) chord-name))

