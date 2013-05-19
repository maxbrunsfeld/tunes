(ns app.routes
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [app.apis.tune :as tune]
            [app.apis.specs :as specs]
            [ring.util.response :as resp]))

(defroutes routes
  (GET "/" [] (resp/redirect "/tunes"))
  (GET "/tunes" [] (tune/index))
  (POST "/tunes" {p :params} (tune/create p))
  (GET "/tunes/new" [] (tune/new))
  (GET "/tunes/:id" [id] (tune/show id))
  (GET "/specs" [] (specs/show)))
