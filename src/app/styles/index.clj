(ns app.styles.index
  (:use gaka.core))

(def stylesheet-dir
  "resources/public/stylesheets/")

(def styles-ns-path
  "tunes.styles")

(def stylesheets
  ["reset"
   "tune"])

(doseq [stylesheet stylesheets]
  (let
    [filename (str stylesheet-dir stylesheet ".css")
     ns-sym (symbol (str styles-ns-path \. stylesheet))
     rules (do (require ns-sym)
               (-> ns-sym find-ns (ns-resolve 'rules) deref))]
    (apply save-css (cons filename rules))))
