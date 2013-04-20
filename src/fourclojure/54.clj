(ns fourclojure.54
  (:use midje.sweet))

(defn solution [size coll]
  (letfn [(partition [so-far coll]
            (let [split (split-at size coll)]
              (cond
                (> size (count coll)) (list so-far)
                (= size (count coll)) (cons so-far (list coll))
                (empty? so-far) (partition (first split) (last split))
                :else
                (cons so-far (partition (first split) (last split))))))]
    (partition '() coll)))

(defn solution [size coll]
  (take-nth size
            (apply map list (take size (iterate next coll)))))


(fact
  (solution 3 (range 9)) => '((0 1 2) (3 4 5) (6 7 8))
  (solution 2 (range 8)) => '((0 1) (2 3) (4 5) (6 7))
  (solution 3 (range 8)) => '((0 1 2) (3 4 5)))
