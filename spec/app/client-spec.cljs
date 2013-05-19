(ns app.client-spec
  (:use [specljs.run.standard :only (run-specs)])
  (:require [app.controllers.tune-spec]))

(defn run []
  (set! specljs.run.standard/armed true)
  (run-specs))

(run)
