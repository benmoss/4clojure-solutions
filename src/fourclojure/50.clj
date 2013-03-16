(ns fourclojure.50
  (:use midje.sweet))

(defn solution [mixed]
  (vals (group-by type mixed)))

(fact
  (= (set (solution [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
  (= (set (solution [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
  (= (set (solution [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
