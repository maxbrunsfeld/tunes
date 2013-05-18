(ns app.views.render
  (:use [hiccup.core :only [html]]))

(defmacro render
  [& forms]
  `(html ~@forms))
