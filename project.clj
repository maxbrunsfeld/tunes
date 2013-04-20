(defproject tunes "0.1.0-SNAPSHOT"
  :description "A toy project"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/java.jdbc "0.3.0-alpha1"]
                 [postgresql "9.1-901.jdbc4"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [compojure "1.1.3"]
                 [hiccup "1.0.2"]
                 [korma "0.3.0-beta11"]
                 [drift "1.4.5"]]

  :plugins [[lein-ring "0.8.3"]
            [drift "1.4.5"]
            [speclj "2.5.0"]]
  :ring {:handler tunes.app/handler}
  :main tunes.app
  :test-paths ["spec/"]

  :profiles
  {:dev {:dependencies [[speclj "2.5.0"]]}})
