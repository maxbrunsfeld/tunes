(ns app.views.specs
  (:use [app.views.helpers :only (script stylesheet)]))

(defn show
  []
  (list
    [:head
     [:title "Specs"]
     (script "specs")
     (stylesheet "reset")]
    [:body]))
