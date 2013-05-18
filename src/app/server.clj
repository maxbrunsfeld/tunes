(ns app.server
  (:use
    [ring.adapter.jetty :only [run-jetty]]
    [app.routes :only [routes]]
    [ring.middleware.resource :only [wrap-resource]]
    [ring.middleware.params :only [wrap-params]]))

(def handler
  (-> routes
      wrap-params
      (wrap-resource "public")))

(defn -main []
  (run-jetty handler {:port 8000 :join? false}))
