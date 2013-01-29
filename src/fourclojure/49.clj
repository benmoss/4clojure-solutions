(ns fourclojure.49
  (:use midje.sweet))

(defn solution [n c]
  [(take n c) (drop n c)])

(fact 
  (solution 3 [1 2 3 4 5 6]) => [[1 2 3] [4 5 6]]
  (solution 1 [:a :b :c :d]) => [[:a] [:b :c :d]]
  (solution 2 [[1 2] [3 4] [5 6]]) => [[[1 2] [3 4]] [[5 6]]])
