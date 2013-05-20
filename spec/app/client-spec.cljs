(ns app.client-spec
  (:use [specljs.run.standard :only (run-specs)])
  (:require
    [app.audio.wave-tables-spec]
    [app.controllers.tune-spec]
    [app.audio.pitches-spec]))

(defn run []
  (set! specljs.run.standard/armed true)
  (run-specs))

(run)
