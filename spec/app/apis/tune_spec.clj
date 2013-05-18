(ns app.apis.tune_spec
  (:use [speclj.core]
        [wishful.core]
        [wishful.speclj])
  (:require [app.apis.tune :as controller]
            [app.models.tune :as model]
            [net.cgrand.enlive-html :as enlive]))

(defn parse-html
  [string]
  (enlive/html-resource (java.io.StringReader. string)))

(describe "index"
  (spy-on
    (model/all) [{:name "Wave" :chords ["Dm9" "G13"]}
                 {:name "Soon" :chords ["Eb" "Gm7b5" "C7b9" "Fm"]}])

  (it "lists all available tunes"
    (let
      [items (-> (controller/index)
               parse-html
               (enlive/select [:ol.tunes :> :li]))]
      (should= 2 (count items))
      (should= ["Wave" "Soon"]
               (->> (enlive/select items [:a])
                   (map enlive/text))))))

(describe "create"
  (spy-on
    (model/create (any-arg)) nil)

  (it "creates a tune"
    (controller/create {"name" "Nature Boy" "chords" ["Dm7" "Em7b5" "A7"]})
    (should= [{:name "Nature Boy" :chords ["Dm7" "Em7b5" "A7"]}]
             (-> model/create calls first :args))))

