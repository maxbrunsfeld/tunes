(ns config.migrate-config
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            [config.db :as db]))

(defn- ensure-schema-table
  [& args]
  (jdbc/with-connection (db/current)
    (try
      (jdbc/create-table
        :schema_version
        [:version "bigint" "NOT NULL"]
        [:created_at "TIMESTAMP WITH TIME ZONE" "NOT NULL" "DEFAULT now()" ])
      (catch java.sql.BatchUpdateException ex
        (-> ex .getNextException .getMessage)))))

(defn- get-current-version []
  (let
    [initial 0
     in-db (-> (jdbc/query
                 (db/current)
                 (sql/select
                   :version
                   :schema_version))
               last
               :version)]
    (or in-db initial)))

(defn- update-version
  [new-version]
  (jdbc/insert! (db/current)
                :schema_version
                {:version new-version}))

(defn migrate-config []
  {:directory "/src/migrations"
   :ns-content "\n(use clojure.java.jdbc clojure.java.jdbc.sql)"
   :init ensure-schema-table
   :current-version get-current-version
   :update-version update-version})
