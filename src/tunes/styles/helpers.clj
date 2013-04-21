(ns tunes.styles.helpers)

(def horizontally-padded
  (let [x "20px"]
    {:padding-left x :padding-right x}))

(def full-width
  {:width "auto"})

(defn height [h]
  {:height h, :line-height h, :overflow :hidden})
