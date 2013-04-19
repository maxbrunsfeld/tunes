(ns config.db
  (:require [korma.db :as kdb]))

(def params
  {:db "tunes"
   :user "maxbrunsfeld"
   :password ""
   :host "127.0.0.1"
   :port "5432" })

(kdb/defdb dev (kdb/postgres params))
