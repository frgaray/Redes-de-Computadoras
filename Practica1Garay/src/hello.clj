(ns hello)

;; Some clojure examples
(defn hola [_param]
  (println "hola"))

(defn suma-1 [n]
  (+ n 1))

(defn suma-2 [n]
  (println (+ n 4))
  (+ n 2))


;; Sin macro
(map (fn [num]
       (* num 3))
     (filter even?
             (map suma-1
                  (range 1 10))))
;; Con macro
(->> (range 1 10)
     (map suma-1)
     (filter even?)
     (map #(* % 3)))


;; (/ (+ 10 2) 2)
(-> 10
    (+ 2)
    (/ 2))

;; (/ 2 (+ 2 10))
(->> 10
     (+ 2)
     (/ 2))

;(defn fibbonacci [_n]
  ;; tu código
;  )

;(set (filter even? (map fibbonacci (range 20))))
