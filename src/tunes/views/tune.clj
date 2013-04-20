(ns tunes.views.tune
  (:use [hiccup.page :only (html5)]))

(declare layout main stylesheet head tune-url chords-list)

(defn new []
  (layout
    "New Tune"
    [:div]))

(defn index [tunes]
  (layout
    "Tunes"
    [:h2 "Latest Tunes"]
    [:ol
      (for [tune tunes]
        [:li
         [:a {:href (tune-url tune)} (:name tune)]
         (chords-list tune)])]))

(defn show [tune]
  (layout
    (:name tune)
    [:h2 (:name tune)]
    (chords-list tune)))

;; Partials

(defn- layout [title & content]
  (html5
    [:head
     [:title title]]
     (stylesheet "/stylesheets/tune.css")
    [:body
     (head)
     (main content)]))

(defn- main [& content]
  (into [:div#main] content))

(defn- head []
  [:div#head
   [:div.links
    [:a#new-tune {:href "/tunes/new"} "Add a tune"]]
   [:h1 "Tunes"]])

(defn- chords-list
  [tune]
  [:ol.chords
   (for [chord (:chords tune)]
     [:li.chord chord])])

;; Helpers

(defn- tune-url
  [tune]
  (str "/tunes/" (:id tune)))

;; Generic Helpers

(defn stylesheet [filename]
  [:link {:rel "stylesheet" :type "text/css" :href filename}])
