(ns fourclojure.66
  (:use midje.sweet))

(defn solution [x y]
  (if (= 0 y) x
    (recur y (rem x y))))

(fact
  (solution 2 4) => 2
  (solution 10 5) => 5
  (solution 5 7) => 1
  (solution 1023 858) => 33)
