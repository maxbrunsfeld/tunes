(ns app.apis.tune
  (:require [app.views.tune :as view]
            [app.models.tune :as model]
            [ring.util.response :as resp])
  (:use [app.views.render :only [render]]))

(declare symbolize-keys)

(defn index []
  (render (view/index (model/all))))

(defn show [id]
  (render (view/show (model/find-by-id (Integer/parseInt id)))))

(defn new []
  (render (view/new)))

(defn create [values]
  (model/create (symbolize-keys values))
  (resp/redirect "/tunes"))

(defn- symbolize-keys [m]
  (into {} (for [[k v] m]
             [(keyword k) v])))
