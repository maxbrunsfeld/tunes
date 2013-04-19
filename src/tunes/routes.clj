(ns tunes.routes
  (:use [compojure.core :only (defroutes GET)])
  (:require [tunes.controllers.tune :as tune]
            [ring.util.response :as resp]))

(defroutes routes
  (GET "/" [] (resp/redirect "/tunes"))
  (GET "/tunes" [] (tune/index))
  (GET "/tunes/:id" [id] (tune/show id)))
