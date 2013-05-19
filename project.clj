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

                 ;; For clojurescript
                 [prismatic/dommy "0.1.1"]]

  :plugins [[lein-ring "0.8.3"]
            [drift "1.4.5"]
            [speclj "2.7.2"]
            [lein-cljsbuild "0.3.2"]]

  :ring {:handler app.server/handler}
  :main app.server
  :test-paths ["spec/"]

  :test-commands {"client" ["phantomjs"
                            "resources/phantom/specs.js"
                            "resources/public/specs.html"]}

  :cljsbuild {:crossover-path "target/cljs-crossovers"

              :crossovers
              [app.views.tune
               app.views.layouts
               app.views.helpers]

              :builds
              {:dev
               {:source-paths ["src"]
                :compiler
                {:output-to "resources/public/js/app.js"
                 :optimizations :whitespace
                 :pretty-print true}}

               :specs
               {:source-paths ["src" "spec"]
                :compiler
                {:output-to "resources/public/js/specs.js"
                 :optimizations :whitespace
                 :pretty-print true}}
               }}

  :profiles
  {:dev {:dependencies [[speclj "2.7.2"]
                        [specljs "2.7.2"]
                        [clj-webdriver "0.6.0-beta2"]
                        [org.apache.httpcomponents/httpcore "4.2.3"]
                        [com.github.detro.ghostdriver/phantomjsdriver "1.0.1"]
                        [enlive "1.0.0"]
                        [wishful "0.1.1"]
                        ]}})
