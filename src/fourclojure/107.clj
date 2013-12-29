(ns fourclojure.107
  (:use clojure.test))

(defn answer [x]
  (partial #(apply * (repeat % %2)) x))

(is (= 256 ((answer 2) 16), ((answer 8) 2)))

(is (= [1 8 27 64] (map (answer 3) [1 2 3 4])))

(is (= [1 2 4 8 16] (map #((answer %) 2) [0 1 2 3 4])))
