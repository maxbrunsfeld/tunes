(ns tunes.app
  (:require 
    [tunes.routes :as routes]
    [ring.adapter.jetty :as ring]
    [ring.middleware.resource :as resource]))

(def handler
  (-> routes/routes
      (resource/wrap-resource "public")))

(defn -main []
  (ring/run-jetty handler {:port 8000 :join? false}))
