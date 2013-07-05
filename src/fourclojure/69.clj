(ns fourclojure.69
  (:use midje.sweet))

(defn solution [f & maps]
  (let [keyz (set (mapcat keys maps))
        grouped-by-key (map #(remove nil? %) (map (fn [k] (map #(get % k) maps)) keyz))
        valz (map #(if (> (count %) 1) (apply f %) (first %)) grouped-by-key)]
    (zipmap keyz valz)))


(fact
  (solution * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5}) =>
  {:a 4, :b 6, :c 20}

  (solution - {1 10, 2 20} {1 3, 2 10, 3 15}) =>
  {1 7, 2 10, 3 15}

  (solution concat {:a [3], :b [6]} {:a [4 5], :c [8 9]}, {:b [7]}) =>
  {:a [3 4 5], :b [6 7], :c [8 9]})
