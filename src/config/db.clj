(ns config.db
  (:use [korma.db]))

(def spec
  {:subprotocol "postgresql"
   :host "127.0.0.1"
   :port "5432"
   :db "tunes"
   :user "maxbrunsfeld"
   :password ""
   :subname "//127.0.0.1:5432/tunes" })

(defdb dev (postgres spec))
