(ns migrations.001-create-tunes
  (:require [clojure.java.jdbc :as jdbc]
            [config.db :as db]
            [config.migrate-config :as c]))

(defn up []
  (jdbc/with-connection db/spec
    (jdbc/create-table
      :tunes
      [:id "SERIAL" "NOT NULL"]
      [:name "varchar(255)" "NOT NULL"]
      [:chords "varchar(255)[]" "NOT NULL"])))

(defn down []
  (jdbc/with-connection db/spec
    (jdbc/drop-table :tunes)))
