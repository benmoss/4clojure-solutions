(ns fourclojure.90)

(defn answer [x y]
  (set (partition 2 (mapcat #(interleave (repeat %) y) x))))

(interleave #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})


(= (answer #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= (answer #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (answer (into #{} (range 10))
                      (into #{} (range 30)))))
