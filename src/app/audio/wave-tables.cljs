(ns app.audio.wave-tables
  (:use [app.audio.base :only (*audio-context*)]))

(declare wave-table)

(defn major []
  (wave-table [0 0 0 0] [0 3 3 1]))

(defn- float-array [coll]
  (js/Float32Array. (to-array coll)))

(defn- wave-table [sines cosines]
  (.createWaveTable
    *audio-context*
    (float-array sines)
    (float-array cosines)))

