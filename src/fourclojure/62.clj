(ns fourclojure.62
  (:use midje.sweet))

(defn solution [f i]
  (cons i (lazy-seq (solution f (f i)))))

(fact
  (take 5 (solution #(* 2 %) 1)) => [1 2 4 8 16]
  (take 100 (solution inc 0)) => (take 100 (range))
  (take 9 (solution #(inc (mod % 3)) 1)) => (take 9 (cycle [1 2 3])))
