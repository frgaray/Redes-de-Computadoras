(ns send-email
  (:require
   [postal.core :refer [send-message]]
   [email-password :refer [pass]]))

;; SMTP usage example
(defn send-me-an-email! [_opts]
  (send-message {:host "smtp.gmail.com"
                 :user "frga@ciencias.unam.mx"
                 :pass pass
                 :port 587
                 :tls  true}
                {:from    "frga@ciencias.unam.mx"
                 :to      ["frga@ciencias.unam.mx"]
                 :subject "Subject"
                 :body    "Test."}))
