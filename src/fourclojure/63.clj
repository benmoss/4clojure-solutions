(ns fourclojure.63
  (:use midje.sweet))

(defn solution
  ([f v] (solution {} f v))
  ([m f s] (if-let [x (first s)]
             (let [key (f x)
                   val (conj (or (m key) []) x)]
               (recur (assoc m key val)
                      f
                      (rest s)))
             m)))


(fact
  (solution #(> % 5) [1 3 6 8]) =>
    {false [1 3], true [6 8]}
  (solution #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) =>
    {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}
  (solution count [[1] [1 2] [3] [1 2 3] [2 3]]) =>
    {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
