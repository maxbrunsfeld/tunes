(ns tunes.models.tune
  (:require [clojure.string :as string]
            [config.db])
  (:use korma.core)
  (:import java.sql.Array))

(declare update-chords seq->sql-array sql-array->seq)

(defentity tunes
  (prepare #(update-chords % seq->sql-array))
  (transform #(update-chords % sql-array->seq)))

(defn all []
  (select tunes))

(defn find-by-id [id]
  (-> (select tunes (where {:id id}) (limit 1)) first))

(defn create [attrs]
  (insert tunes (values attrs)))

(defn destroy-all []
  (delete tunes))

(defn- seq->sql-string
  [coll]
  (let
    [entries (map #(str \" % \") coll)]
    (str \{ (string/join ", " entries) \})))

(deftype SqlArray [coll]
  java.sql.Array
  (getBaseTypeName [this] "varchar")
  (toString [this] (seq->sql-string coll)))

(defn- update-chords [tune f] (update-in tune [:chords] f))
(defn- seq->sql-array [coll] (SqlArray. coll))
(defn- sql-array->seq [arr] (-> arr .getArray seq))
