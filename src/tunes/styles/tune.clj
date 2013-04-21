(ns tunes.styles.tune
  (:use tunes.styles.helpers))

(def rules
  [
   ["#head, #subhead, #main"
    full-width
    horizontally-padded]

   ["#head"
    (height "50px")
    {:color "#333"
     :background-color "#ccc"}]

   ["#subhead"
    (height "30px")
    :border-bottom "1px solid #aaa"]

   ["#nav-links li"
    :display "inline"
    :margin-right "20px"]

   ["#main"
    {:padding-top "20px"}]

   [".links"
    :float :right]

   ["input"
    :display :block
    :margin "20px 0"]
   ])
