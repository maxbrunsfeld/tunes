(ns tunes.app
  (:require 
    [tunes.routes :as routes]
    [ring.adapter.jetty :as ring]))

(def handler routes/routes)

(defn -main []
  (ring/run-jetty handler {:port 8000 :join? false}))
