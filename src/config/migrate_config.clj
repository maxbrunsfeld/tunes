(ns config.migrate-config
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            [drift.builder :as d]
            [config.db :as db]))

(defn- catch-sql-errors [f]
  (try (f)
    (catch java.sql.BatchUpdateException ex
      (->> ex .getNextException .getMessage (.println *err*)))))

(defn- ensure-schema-table [& args]
  (jdbc/with-connection db/spec
    (catch-sql-errors
      #(jdbc/create-table
         :schema_version
         [:version "bigint" "NOT NULL"]
         [:created_at "TIMESTAMP WITH TIME ZONE" "NOT NULL" "DEFAULT now()" ]))))

(defn- get-current-version []
  (or
    (-> (jdbc/query db/spec (sql/select * :schema_version)) last :version)
    0))

(defn- update-version
  [new-version]
  (jdbc/insert!
    db/spec
    :schema_version
    {:version new-version}))

(defn migrate-config []
  {:directory "/src/migrations"
   :ns-content "\n(use clojure.java.jdbc clojure.java.jdbc.sql)"
   :init ensure-schema-table
   :current-version get-current-version
   :update-version update-version
   :migration-number-generator d/incremental-migration-number-generator})
