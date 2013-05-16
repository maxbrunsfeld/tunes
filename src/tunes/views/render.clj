(ns tunes.views.render
  (:require [hiccup.core :as hiccup]))

(defmacro render
  [& forms]
  `(hiccup/html ~@forms))
