(ns app.client-spec
  (:require [app.controllers.tune-spec]))

(defn run []
  (app.controllers.tune-spec/run))

(run)
