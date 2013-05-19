(ns app.views.tune
  (:require [app.views.layouts :as layouts]))

(declare chords-list tune-url)

(defn new []
  (layouts/main
    {:title "New Tune" :section "new"}
    [:h2 "Add a Tune"]
    [:form {:action "/tunes" :method "POST"}
     [:input {:name "name" :type "text" :placeholder "Name"}]
     [:textarea {:name "chords" :placeholder "Chords"}]
     [:input {:type "submit" :value "Save"}]]))

(defn index [tunes]
  (layouts/main
    {:title "Tunes" :section "index"}
    [:h2 "Latest Tunes"]
    [:ol.tunes
     (for [tune tunes]
       [:li
        [:a {:href (tune-url tune)} (:name tune)]
        (chords-list tune)])]))

(defn show [tune]
  (layouts/main
    {:title (:name tune) :section "show"}
    [:h2 (:name tune)]
    (chords-list tune)))

;; Helpers

(defn- chords-list
  [tune]
  [:ol.chords
   (for [chord (:chords tune)]
     [:li.chord chord])])

(defn tune-url
  [tune]
  (str "/tunes/" (:id tune)))
