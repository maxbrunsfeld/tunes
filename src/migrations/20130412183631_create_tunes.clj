(ns migrations.20130412183631-create-tunes
  (require [clojure.java.jdbc :as jdbc]
           [config.db :as db]))

(defn up []
  (jdbc/with-connection (db/current)
    (jdbc/create-table
      :tunes
      [:id "integer" "NOT NULL"]
      [:user_id "integer" "NOT NULL"]
      [:name "varchar(255)" "NOT NULL"]
      [:chords "varchar(255)[]" "NOT NULL"])

    (jdbc/create-table
      :users
      [:id "integer" "NOT NULL"]
      [:name "varchar(255)" "NOT NULL"]
      [:chords "varchar(255)[]" "NOT NULL"])))

(defn down []
  (jdbc/with-connection (db/current)
    (jdbc/drop-table :tunes)
    (jdbc/drop-table :users)))
