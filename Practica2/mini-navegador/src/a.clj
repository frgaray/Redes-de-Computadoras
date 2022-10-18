
(ns a)

(defn a [string]
  (str "GET " string " " "HTTP/1.1" 
                "\r\nHost: " (first (clojure.string/split string #"/"))
                "\r\nAccept: text/html"
                "\r\nAccept-language: esp" 
                "\r\nConnection: close"
                "\r\nDate: " (.toString (java.util.Date.)) ) )

