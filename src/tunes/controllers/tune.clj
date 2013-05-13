(ns tunes.controllers.tune
  (:require [tunes.views.tune :as view]
            [tunes.models.tune :as model]
            [ring.util.response :as resp]))

(declare symbolize-keys)

(defn index []
  (view/index (model/all)))

(defn show [id]
  (view/show (model/find-by-id (Integer/parseInt id))))

(defn new []
  (view/new))

(defn create [values]
  (model/create (symbolize-keys values))
  (resp/redirect "/tunes"))

(defn- symbolize-keys [m]
  (into {} (for [[k v] m]
             [(keyword k) v])))
