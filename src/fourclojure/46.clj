(ns fourclojure.46
  (:use midje.sweet))

(defn solution [f] #(f %2 %))

(fact
  ((solution nth) 2 [1 2 3 4 5]) => 3
  ((solution >) 7 8) => true
  ((solution quot) 2 8) => 4
  ((solution take) [1 2 3 4 5] 3) => [1 2 3])
