(ns c
  (:require
   [a]
   [b]
   [clojure.java.io :as io]))

(defn file-writer [file-name content]
  (with-open [w (io/writer file-name)]
    (.write w (str content))))

(defn http-get-writer [url output-name]
  (file-writer output-name 
               (b/b (a/a url))))
