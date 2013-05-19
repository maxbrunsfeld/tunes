(ns app.views.specs
  (:use [app.views.helpers :only (script stylesheet)]))

(defn show
  []
  (list
    [:head
     (script "specs")
     (stylesheet "reset")]
    [:body]))
