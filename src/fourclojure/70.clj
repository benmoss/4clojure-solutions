(ns fourclojure.70
  (:use midje.sweet))

(defn solution [x]
  (let [words (clojure.string/split x #"[ .!]")]
    (sort #(compare (.toLowerCase %) (.toLowerCase %2)) words)))

(fact
  (solution  "Have a nice day.") => ["a" "day" "Have" "nice"]

  (solution  "Clojure is a fun language!") => ["a" "Clojure" "fun" "is" "language"]

  (solution  "Fools fall for foolish follies.") => ["fall" "follies" "foolish" "Fools" "for"])
