(ns graph.prueba)

(let [vertices (map #(keyword (str %)) (range 6))] 
  (zipmap vertices vertices))

(defn make-verts [n]
  (zipmap (map #(keyword (str %)) (range n)) (repeat [])))

(defn random-key [map]
  (rand-nth (keys map)))

(def graph1 (make-verts 10))

(defn random-edge [graph]
  (let [i (random-key graph1)]
    (assoc graph1 i
           (zipmap [:vertex] [(random-key (dissoc graph1 i))])))
)

(random-key (dissoc graph1 i))

(graph1 i)

(let [i 1] i)

(let [i 1]
  (while (not= i 0) (let [i (rand-int 1)]) i))




(not= 1 0)



(rand-int 10)


;;(for [x (range m)]
 ;; )

;;(get-in)



(defn free-legs? [m i d]
  (< (count (m i)) d))

(defn free-leg-indices [m n d]
  (filter #(free-legs? m % d) (range n)))

(defn first-free-leg [m n d]
  (first (free-leg-indices m n d)))

(defn random-free-leg [m n d]
  (let [fli (free-leg-indices m n d)
        fl-counts (zipmap fli (map #(- d (count (m %))) fli))
        fli2 (mapcat #(repeat (fl-counts %) %) fli)]
    (nth fli2 (rand-int (count fli2)))))

(defn add-random-edge [m n d]
  (let [i1 (first-free-leg m n d)
        i2 (random-free-leg (update-in m [i1] conj 'dummy) n d)]
    (update-in (update-in m [i1] conj i2) [i2] conj i1)))

(defn d-regular-graph-edges [n d]
  (/ (* n d) 2))

(defn random-d-regular-graph [n d]
  (nth
   (iterate #(add-random-edge % n d) (make-verts n))
   (d-regular-graph-edges n d)))

reduce