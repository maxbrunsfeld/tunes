(ns tasks.drop-db
  (:require [config.db :as db])
  (:use tasks.utils))

(defn -main [] (sh "dropdb" (db/params :db)))
