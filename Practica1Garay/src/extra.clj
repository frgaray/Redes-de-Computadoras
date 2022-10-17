(ns extra)

(defn line-reader [reader]
        (loop [actual-line (.read reader)]
          (if (not= actual-line -1)
            (do
              (print (char actual-line))
              (recur (.read reader))))))

(with-open [reader (clojure.java.io/input-stream "ejercicios_tarea.md")]
  (line-reader reader))