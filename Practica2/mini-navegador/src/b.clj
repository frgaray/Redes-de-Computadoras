(ns b)

(defn b [peticion]
  (let [s   (Socket. "www.columbia.edu" 80)
        wtr (PrintWriter. (.getOutputStream s))]
    (.println wtr peticion)
    (.println wtr "Host: www.columbia.edu")
    (.println wtr "")
    (.flush wtr)
    ;;
    (let [rdr (-> s
                  (.getInputStream)
                  (InputStreamReader.)
                  (BufferedReader.))
          a   (atom nil)]

      (while (some? (reset! a (.readLine rdr)))
        (println @a)))))