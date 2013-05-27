(ns fourclojure.45
  (:use midje.sweet))

(def solution [1 4 7 10 13])

(fact 
  solution => (take 5 (iterate #(+ 3 %) 1)))
