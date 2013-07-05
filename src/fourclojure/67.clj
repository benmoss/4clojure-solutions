(ns fourclojure.67
  (:use midje.sweet))

(defn solution [n]
  (letfn [(prime? [x] (not (some #(zero? (mod x %)) (range 2 x))))]
    (take n (filter prime? (iterate inc 2)))))

(fact 
  (solution 2) => [2 3]
  (solution 5) => [2 3 5 7 11]
  (last (solution 100)) => 541)
