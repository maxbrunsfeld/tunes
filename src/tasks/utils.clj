(ns tasks.utils
  (require [clojure.java.shell :as shell]))

(defn sh
  [& args]
  (apply println args)
  (apply shell/sh args))
