
(ns a)

(defn a [string]
  (println (str "GET " string " " "HTTP/1.1" 
                "\nHost: " (first (clojure.string/split string #"/"))
                "\nAccept: text/html"
                "\nAccept-language: esp" 
                "\nConnection: close"
                "\nDate: " (.toString (java.util.Date.)) )) )

