(ns app.views.helpers)

(defn inline-script [code]
  [:script {:type "text/javascript"} code])

(defn script [name]
  [:script {:type "text/javascript" :src (str "/js/" name ".js")}])

(defn stylesheet [filename]
  [:link {:rel "stylesheet" :type "text/css" :href (str "/stylesheets/" filename ".css")}])
