(ns tunes.views.tune
  (:use [hiccup.page :only (html5)]))

(declare layout main stylesheet head subhead tune-url chords-list)

(defn new []
  (layout
    {:title "New Tune" :section "new"}
    [:h2 "Add a Tune"]
    [:form {:action "/tunes" :method "POST"}
     [:input {:name "name" :type "text" :placeholder "Name"}]
     [:textarea {:name "chords" :placeholder "Chords"}]
     [:input {:type "submit" :value "Save"}]]))

(defn index [tunes]
  (layout
    {:title "Tunes" :section "index"}
    [:h2 "Latest Tunes"]
    [:ol.tunes
      (for [tune tunes]
        [:li
         [:a {:href (tune-url tune)} (:name tune)]
         (chords-list tune)])]))

(defn show [tune]
  (layout
    {:title (:name tune) :section "show"}
    [:h2 (:name tune)]
    (chords-list tune)))

;; Partials

(defn- layout
  [{:keys [title section-name]} & content]
  (html5
    [:head
     [:title title]]
     (stylesheet "tune")
     (stylesheet "reset")
    [:body
     (head)
     (subhead section-name)
     (main content)]))

(defn- main [& content]
  (into [:div#main] content))

(defn- head []
  [:div#head
   [:h1 "Tunes"]])

(def nav-links
  {"Most Recent Tunes" "/tunes"
   "Add a Tune" "/tunes/new"})

(defn- subhead [current-section]
  [:div#subhead
   [:ol#nav-links
    (for [[text url] nav-links]
      [:li [:a {:href url} text]])]])

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
  [:link {:rel "stylesheet" :type "text/css" :href (str "/stylesheets/" filename ".css")}])
