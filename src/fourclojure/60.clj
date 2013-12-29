(ns fourclojure.60
  (:use midje.sweet))

(defn solution
  ([f coll]
   (solution f (first coll) (rest coll)))
  ([f val coll]
   (cons val
         (lazy-seq
           (when-let [s (seq coll)]
             (solution f (f val (first s)) (rest s)))))))

(fact
  (take 5 (solution + (range))) => [0 1 3 6 10]
  (solution conj [1] [2 3 4]) => [[1] [1 2] [1 2 3] [1 2 3 4]]
  (last (solution * 2 [3 4 5])) => 120)
