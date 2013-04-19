(ns tunes.controllers.tune
  (:require [tunes.views.tune :as view]
            [tunes.models.tune :as model]))

(defn index []
  (view/index (model/all)))

(defn show [id]
  (view/show (model/find-by-id (Integer/parseInt id))))
