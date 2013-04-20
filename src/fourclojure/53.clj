(ns fourclojure.53
  (:use midje.sweet))

(def coll [0 1 2 3])

(defn log [coll]
  (do
    (println "LOG: " coll)
    coll))

(defn solution [coll]
  (->> (partition 2 1 coll)
       (partition-by #(- (second %) (first %)))
       (filter #(= 1 (- (second (first %)) (ffirst %))))
       (reduce #(if (> (count %1) (count %2)) %1 %2) [])
       flatten
       distinct))


(fact
  (solution [1 0 1 2 3 0 4 5]) => [0 1 2 3]
  (solution [5 6 1 3 2 7]) => [5 6]
  (solution [2 3 3 4 5]) => [3 4 5]
  (solution [7 6 5 4]) => [])
