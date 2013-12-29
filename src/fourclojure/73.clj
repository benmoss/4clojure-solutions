(ns fourclojure.73)

(defn answer [board]
  (let [original board
        rotated (apply map list board)
        diagonals [(map-indexed (fn [i x] (nth x i)) board)
                   (map-indexed (fn [i x] (nth x (- 2 i))) board)
                   [:e :e :e]]
        possibles (filter #(and (not (= [:e] %)) (= 1 (count %)))
                          (map distinct (concat original rotated diagonals)))]
    (ffirst possibles)))


(= nil (answer [[:e :e :e]
                [:e :e :e]
                [:e :e :e]]))

(= :x (answer [[:x :e :o]
               [:x :e :e]
               [:x :e :o]]))

(= :o (answer [[:e :x :e]
               [:o :o :o]
               [:x :e :x]]))

(= nil (answer [[:x :e :o]
                [:x :x :e]
                [:o :x :o]]))

(= :x (answer [[:x :e :e]
               [:o :x :e]
               [:o :e :x]]))

(= :o (answer [[:x :e :o]
               [:x :o :e]
               [:o :e :x]]))

(= nil (answer [[:x :o :x]
                [:x :o :x]
                [:o :x :o]]))
