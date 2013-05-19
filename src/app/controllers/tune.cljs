(ns app.controllers.tune
  (:require [app.views.tune :as view]
            [dommy.core :as dom])
  (:use-macros [dommy.macros :only [sel sel1]]
               [app.views.render-client :only [render]]))

(declare chord-clicked)

(defn start []
  (setup-chord-clicks))

(defn setup-chord-clicks []
  (dom/listen! [(sel1 :body) :.tunes :li.chord] :click chord-clicked))

(defn chord-clicked [x]
  (println x))
