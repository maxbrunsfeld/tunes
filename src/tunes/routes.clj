(ns tunes.routes
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [tunes.controllers.tune :as tune]
            [ring.util.response :as resp]))

(defroutes routes
  (GET "/" [] (resp/redirect "/tunes"))
  (GET "/tunes" [] (tune/index))
  (POST "/tunes" {p :params} (tune/create p))
  (GET "/tunes/new" [] (tune/new))
  (GET "/tunes/:id" [id] (tune/show id)))
