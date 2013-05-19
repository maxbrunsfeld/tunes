(ns app.client
  (:require [app.controllers.tune :as controller]))

(set! *print-fn* #(.log js/console %))

(defn -main [] (controller/start))
(js/setTimeout -main 0)
