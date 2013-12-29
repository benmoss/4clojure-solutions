(ns fourclojure.99
  (:use clojure.test))

(defn answer [x y]
  (map #(-> % str read-string) (str (* x y))))

(is (= (answer 1 1) [1]))
(is (= (answer 99 9) [8 9 1]))
(is (= (answer 999 99) [9 8 9 0 1]))
