(ns fourclojure.65
  (:use midje.sweet))

(defn solution [x]
  (cond
    (= (first (conj x {1 2} {0 0} {1 2})) {0 0}) :set
    (= (last  (conj x {1 2} {3 4})) {3 4}) :vector
    (= (first (conj x {1 2} {2 3} {1 2})) {1 2}) :list
    (= (first (conj x {1 2})) [1 2]) :map
    :else (println x)))

(fact
  (solution {:a 1, :b 2}) => :map
  (solution (range (rand-int 20))) => :list
  (solution [1 2 3 4 5]) => :vector
  (solution #{10 (rand-int 5)}) => :set
  (map solution [{} #{} [] '()]) => [:map :set :vector :list])
