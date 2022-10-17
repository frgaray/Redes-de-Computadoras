(ns c
  (:require
   [a]
   [b]
   [clojure.java.io]))

(defn file-writer [file-name content]
  (with-open [w (clojure.java.io/writer file-name)]
    (.write w (str content))))

(defn http-get-writer [url output-name]
  (file-writer output-name
               (b/b (a/a url))))
