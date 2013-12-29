(ns fourclojure.74)

(defn answer [x]
  (clojure.string/join "," (filter (fn [s]
                                     (let [f (float (read-string s))
                                           sqrt (Math/sqrt f)]
                                       (= f (* sqrt sqrt))))
                                   (clojure.string/split x #","))))

(= (answer "4,5,6,7,8,9") "4,9")
(= (answer "15,16,25,36,37") "16,25,36")
