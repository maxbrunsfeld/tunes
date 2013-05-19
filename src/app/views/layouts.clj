(ns app.views.layouts
  (:use [app.views.helpers
         :only
         (script inline-script stylesheet)]))

(declare subhead nav-links)

(defn main
  [{:keys [title section-name]} & content]
  (list
    [:head
     (script "app")
     [:title title]
     (stylesheet "tune")
     (stylesheet "reset")]
    [:body
     [:div#head
      [:h1 "Tunes"]]
     (subhead section-name)
     (into [:div#main] content)]))

(defn- subhead [current-section]
  [:div#subhead
   [:ol#nav-links
    (for [[text url] nav-links]
      [:li [:a {:href url} text]])]])

(def nav-links
  {"Most Recent Tunes" "/tunes"
   "Add a Tune" "/tunes/new"})
