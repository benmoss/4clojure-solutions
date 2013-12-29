(ns fourclojure.81
  (:use clojure.test))

(defn answer [x y]
  (set (filter x y)))
(is (= (answer #{0 1 2 3} #{2 3 4 5}) #{2 3}))
(is (= (answer #{0 1 2} #{3 4 5}) #{}))
(is (= (answer #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))
