(ns app.audio.base)

(def *audio-context* (js/webkitAudioContext.))

(def main-output
  (let [filter (.createBiquadFilter *audio-context*)]
    (.connect filter (.-destination *audio-context*))
    (set! (.-type filter) "lowpass")
    (set! (.-value (.-frequency filter)) 300)
    (set! (.-value (.-Q filter)) 10)
    filter))

