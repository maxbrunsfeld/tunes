(ns app.audio.wave-tables-spec
  (:use-macros [specljs.core :only (describe it)])
  (:require [specljs.core]
            [app.audio.wave-tables :as tables]))

(describe "wave-tables"
  (describe "major"
    (it "returns a wave table"
      (assert (= (-> (tables/major) .-constructor .-name) "WaveTable")))
    ))

