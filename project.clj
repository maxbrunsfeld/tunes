(defproject tunes "0.1.0-SNAPSHOT"
  :description "A toy project"
  :url "http://github.com/maxbrunsfeld/tunes"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/java.jdbc "0.3.0-alpha1"]
                 [postgresql "9.1-901.jdbc4"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [compojure "1.1.3"]
                 [hiccup "1.0.2"]
                 [korma "0.3.0-beta11"]
                 [gaka "0.3.0"]
                 [drift "1.4.5"]
                 [crate "0.2.4"]]

  :plugins [[lein-ring "0.8.3"]
            [drift "1.4.5"]
            [speclj "2.5.0"]
            [lein-cljsbuild "0.3.2"]]

  :ring {:handler tunes.app/handler}
  :main tunes.app
  :test-paths ["spec/"]

  :cljsbuild {:crossovers [tunes.views.tune tunes.views.helpers]
              :crossover-path "target/cljs-crossovers"
              :builds
              [{:source-paths ["src-cljs"]
                :compiler
                {:output-to "resources/public/js/app.js"
                 :optimizations :whitespace
                 :pretty-print true}}]}

  :profiles
  {:dev {:dependencies [[speclj "2.5.0"]
                        [clj-webdriver "0.6.0-beta2"]
                        [org.apache.httpcomponents/httpcore "4.2.3"]
                        [com.github.detro.ghostdriver/phantomjsdriver "1.0.1"]
                        [enlive "1.0.0"]
                        ; [wishful "0.1.1"]
                        ]}})
