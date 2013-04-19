(ns tunes.views.tune
  (:use [hiccup.page :only (html5)]))

(declare tune-url chords-list)

(defn- layout
  [& {:keys [title content]}]
  (html5
    [:head [:title title]]
    [:body content]))

(defn index
  "Displays a list of tunes"
  [tunes]
  (layout
    :title "Tunes"
    :content
    [:ol
      (for [tune tunes]
        [:li
         [:a {:href (tune-url tune)} (:name tune)]
         (chords-list tune)])]))

(defn show
  "Displays a tune"
  [tune]
  (layout
    :title (:name tune)
    :content
    [:div
     [:h1 (:name tune)]
     (chords-list tune) ]))

(defn- chords-list
  [tune]
  [:ol {:class "chords"}
   (for [chord (:chords tune)]
     [:li chord])])

(defn- tune-url
  [tune]
  (str "/tunes/" (:id tune)))
