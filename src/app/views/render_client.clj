(ns app.views.render-client
  (:use [dommy.macros :only [node]]))

(defmacro render
  [& forms]
  `(node ~@forms))
