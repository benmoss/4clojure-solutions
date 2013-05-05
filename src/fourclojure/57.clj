(ns fourclojure.55
  (:use midje.sweet))

(defn solution [& fns]
  (fn [& xs] (map #(apply % xs) fns)))


(fact
  [21 6 1] => ((solution + max min) 2 3 5 1 6 4)
  ["HELLO" 5] => ((solution #(.toUpperCase %) count) "hello")
  [2 6 4] => ((solution :a :c :b) {:a 2, :b 4, :c 6, :d 8, :e 10}))

