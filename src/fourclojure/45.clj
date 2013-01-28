(ns fourclojure.45
  (:use midje.sweet))

(fact 
  (= solution (take 5 (iterate #(+ 3 %) 1)))
