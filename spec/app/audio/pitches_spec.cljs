(ns app.audio.pitches-spec
  (:use-macros [specljs.core :only (describe it)])
  (:require [specljs.core]
            [app.audio.pitches :as p]))

(defn close? [x y]
  (let [delta (.abs js/Math (- x y))]
    (< delta 1)))

(def fifth (/ 3 2))
(def fourth (/ 4 3))
(def octave 2)

(def middle-c 261.626)
(def middle-f (* middle-c fourth))
(def middle-b-flat (/ middle-f fifth))
(def middle-g (* middle-c fifth))
(def high-c (* middle-c octave))

(describe "parse-note"
  (it "gets the note name"
    (assert (= (:name (p/parse-note "c3")) "C"))
    (assert (= (:name (p/parse-note "C3")) "C"))
    (assert (= (:name (p/parse-note "F#2")) "F"))
    (assert (= (:name (p/parse-note "Gb2")) "G"))))

(describe "name->pitch"
  (it "works for natural notes"
    (assert (close? (p/name->pitch "C3") middle-c))
    (assert (close? (p/name->pitch "F3") middle-f))
    (assert (close? (p/name->pitch "G3") middle-g))
    (assert (close? (p/name->pitch "C4") high-c)))

  (it "works for sharps and flats"
    (assert (close? (p/name->pitch "Bb3") middle-b-flat))
    (assert (close? (p/name->pitch "A#3") middle-b-flat))))
