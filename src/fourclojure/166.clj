(ns fourclojure.166
  (:use clojure.test))

(defn answer [fn x y]
  (cond
    (= (fn x y) (fn y x)) :eq
    (fn x y) :lt
    (fn y x) :gt))

(defn answer [f x y]
  ({[true true] :eq
    [false false] :eq
    [true false] :lt
    [false true] :gt} [(f x y) (f y x)]))

(is (= :gt (answer < 5 1)))
(is (= :eq (answer (fn [x y] (< (count x) (count y))) "pear" "plum")))
(is (= :lt (answer (fn [x y] (< (mod x 5) (mod y 5))) 21 3)))
(is (= :gt (answer > 0 2)))
