(ns app.audio.player
  (:use [app.audio.base :only (*audio-context* main-output)])
  (:require [app.audio.wave-tables :as wave-tables]
            [app.audio.pitches :as pitch]))

(defn now [] (.-currentTime *audio-context*))

(defrecord Voice [oscillator amp])

(defn make-voice []
  (let
    [oscillator (.createOscillator *audio-context*)
     amp (.createGain *audio-context*)]
    (.connect amp main-output)
    (set! (.-value (.-gain amp)) 0)
    (set! (.-value (.-frequency oscillator)) 200)
    (.start oscillator 0)
    (.connect oscillator amp)
    (.setWaveTable oscillator (wave-tables/major))
    (Voice. oscillator amp)))

(defn play-tone [voice pitch]
  (let [f (.-frequency (:oscillator voice))
        v (.-gain (:amp voice))
        t (now)]
    (.cancelScheduledValues v t)
    (.linearRampToValueAtTime v 0 t)
    (.setValueAtTime f pitch t)
    (.linearRampToValueAtTime v 1.0 (+ t 0.01))
    (.linearRampToValueAtTime v 0 (+ t 1.0))
    voice))

(def top-voice (make-voice))

(defn play-chord [chord-name]
  (.log js/console (play-tone top-voice (pitch/name->pitch chord-name)) chord-name))
