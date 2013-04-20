(ns tunes.styles.tune
  (:use gaka.core))

(declare horizontally-padded full-width)

(def rules
  [
   ["body"
    :font-family "Helvetica, Arial, Sans-Serif"
    :margin 0]

   ["ol"
    :list-style-type "none"]

   ["#head"
    full-width
    horizontally-padded

    (let
      [height "50px"]
      {:height height
       :line-height height})

    {:overflow :hidden
     :color "#333"
     :background-color "#ccc"
     }]

   ["#main"
    full-width
    horizontally-padded]

   ["h1"
    :margin 0]

   [".links"
    :float :right]
   ])

;; Helpers

(def horizontally-padded
  (let [x "20px"]
    {:padding-left x :padding-right x}))

(def full-width
  {:width "auto"})

;; Save

(apply
  save-css
  (cons "resources/public/stylesheets/tune.css" rules))
