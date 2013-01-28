(ns fourclojure.47
  (:use midje.sweet))

(def solution 4)

(fact
  (contains? #{4 5 6} solution) => true
  (contains? [1 1 1 1 1] solution) => true
  (contains? {4 :a 2 :b} solution) => true
  (not (contains? '(1 2 4) solution)) => true)
