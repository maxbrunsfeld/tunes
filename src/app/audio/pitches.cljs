(ns app.audio.pitches)

(defn name->pitch [note-str]
  (-> note-str parse-note semitones-above-a4 pitch-for-semitones))

(defn parse-note [note-name]
  (if-let [match (.match note-name note-pattern)]
    {:name
     (-> match (aget 1) .toUpperCase)
     :offset
     (-> match (aget 2) parse-offset)
     :octave
     (-> match (aget 3) first (or 3) js/parseInt)}))

(def a4 440.0)

(def semitones-by-note
  {"A" 0
   "B" 2
   "C" 3
   "D" 5
   "E" 7
   "F" 8
   "G" 10})

(def note-pattern #"([A-Ga-g])([b#]*)(\d*)")

(defn parse-offset [offset]
  (cond
    (= offset "b") -1
    (= offset "#") +1
    :else 0))

(defn pitch-for-semitones [semitones-above-a4]
  (* a4 (.pow js/Math 2.0 (/ semitones-above-a4 12.0))))

(defn semitones-above-a4 [note]
  (+ (* 12 (- (:octave note) 4))
     (semitones-by-note (:name note))
     (:offset note)))
