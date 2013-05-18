(ns app.controllers.tune
  (:require [app.views.tune :as view]
            [dommy.core :as dom])
  (:use-macros [dommy.macros :only [sel sel1]]
               [app.views.render-client :only [render]]))

(defn start []
  (doseq [item (chord-items)]
    (dom/append!
      item
      [:button "hi"])))

(defn chord-items []
  (sel [:.tunes :li.chord]))
