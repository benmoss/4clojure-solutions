(ns fourclojure.44
  (:use midje.sweet))

(defn solution [amount coll]
  (if (neg? amount)
    (take (count coll) (drop (inc (Math/abs amount)) (cycle coll)))
    (take (count coll) (drop amount (cycle coll)))))

(solution -2 [1 2 3 4 5])
(solution 5 [:a :b :c])

(fact
  (solution 2 [1 2 3 4 5]) => '(3 4 5 1 2)
  (solution -2 [1 2 3 4 5]) => '(4 5 1 2 3)
  (solution 6 [1 2 3 4 5]) => '(2 3 4 5 1)
  (solution 1 '(:a :b :c)) => '(:b :c :a)
  (solution -4 '(:a :b :c)) => '(:c :a :b))

