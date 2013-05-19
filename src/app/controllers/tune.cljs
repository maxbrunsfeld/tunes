(ns app.controllers.tune
  (:require [app.views.tune :as view]
            [dommy.core :as dom]
            [app.audio.player :as player])
  (:use-macros [dommy.macros :only [sel sel1]]
               [app.views.render-client :only [render]]))

(declare setup-chord-clicks)

(defn start []
  (setup-chord-clicks))

(defn chord-clicked [e]
  (let
    [chord-item (.-target e)
     chord-name (dom/text chord-item)]
    (player/play-chord chord-name)))

(defn setup-chord-clicks []
  (dom/listen! [(sel1 :body) :.tunes :li.chord] :click chord-clicked))
