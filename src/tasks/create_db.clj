(ns tasks.create-db
  (:require [config.db :as db])
  (:use tasks.utils))

(defn -main [] (sh "createdb" (db/params :db)))
