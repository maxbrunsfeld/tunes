(ns tunes.app
  (:use
    [ring.adapter.jetty :only [run-jetty]]
    [tunes.routes :only [routes]]
    [ring.middleware.resource :only [wrap-resource]]
    [ring.middleware.params :only [wrap-params]]))

(def handler
  (-> routes
      wrap-params
      (wrap-resource "public")))

(defn -main []
  (run-jetty handler {:port 8000 :join? false}))
