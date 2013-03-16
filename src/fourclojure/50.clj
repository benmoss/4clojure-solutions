(ns fourclojure.50
  (:use midje.sweet))

(defn solution [mixed]
  (loop [strings []
         symbols []
         numbers []
         vectors []
         head (first mixed)
         tail (rest mixed)]
    (cond
      (nil? head) (filter not-empty [strings symbols numbers vectors])
      :else (case (str (.getClass head))
              "class java.lang.String" (recur (conj strings head) symbols numbers vectors (first tail) (rest tail))
              "class clojure.lang.Keyword" (recur strings (conj symbols head) numbers vectors (first tail) (rest tail))
              "class java.lang.Long" (recur strings symbols (conj numbers head) vectors (first tail) (rest tail))
              "class clojure.lang.PersistentVector" (recur strings symbols numbers (conj vectors head) (first tail) (rest tail))))))

(fact
  (= (set (solution [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
  (= (set (solution [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
  (= (set (solution [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
