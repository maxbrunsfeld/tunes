(ns app.apis.specs
  (:require [app.views.specs :as view])
  (:use [app.views.render :only [render]]))

(defn show []
  (render (view/show)))
