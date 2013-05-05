(ns fourclojure.55
  (:use midje.sweet))

(defn solution [coll]
  (loop [coll coll acc []]
    (cond (empty? coll)
          acc
          ((set acc) (first coll))
          (recur (next coll) acc)
          :else
          (recur (next coll) (conj acc (first coll))))))

  (= (reduce #(if (some #{%2} %) % (conj % %2)) [] [1 2 1 3 1 2 4]) [1 2 3 4])


(fact
  (solution [1 2 1 3 1 2 4]) => [1 2 3 4]
  (solution [:a :a :b :b :c :c]) [:a :b :c]
  (solution '([2 4] [1 2] [1 3] [1 3])) => '([2 4] [1 2] [1 3])
  (solution (range 50)) => (range 50))
