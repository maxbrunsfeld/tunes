(ns tunes.models.tune-spec
  (:use speclj.core)
  (:require [tunes.models.tune :as tune]))

(describe "creating a tune"
  (before (tune/destroy-all))

  (with inserted-tune
    (tune/create {:name "Louie Louie" :chords ["C" "F" "G"]}))

  (it "returns the tune with its id filled in"
    (should= "Louie Louie" (:name @inserted-tune))
    (should (number? (:id @inserted-tune))))

  (describe "retrieving the tune"
    (it "converts the chords back into a clojure sequence"
      (let [id (:id @inserted-tune)
            found-tune (tune/find-by-id id)
            chords (:chords found-tune)]
        (should= chords ["C" "F" "G"])))))
