(ns fourclojure.61
  (:use midje.sweet))

(defn solution [a b] (apply assoc {} (interleave a b)))
(defn solution [a b] (into {} (map vector a b)))

(fact
  (solution [:a :b :c] [1 2 3]) => {:a 1, :b 2, :c 3}
  (solution [1 2 3 4] ["one" "two" "three"]) => {1 "one", 2 "two", 3 "three"}
  (solution [:foo :bar] ["foo" "bar" "baz"]) => {:foo "foo", :bar "bar"})
