(ns fourclojure.55
  (:use midje.sweet))

(defn solution [mixed]
  (reduce #(assoc % (first %2) (count (second %2)))
          {}
          (group-by identity mixed)))

(fact
  (= (solution [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
  (= (solution [:b :a :b :a :b]) {:a 2, :b 3})
  (= (solution '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))
