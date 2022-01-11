(ns wesleyflorence.day02
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (->> input
         (str/split-lines)
         (map #(let [[direction units] (str/split % #" ")]
                  [direction (Integer/parseInt units)]))))

(defn calc-position
  [directions]
  (reduce (fn [pos [dir units]]
            (cond (= "up" dir) (update pos :depth - units)
                  (= "down" dir) (update pos :depth + units)
                  (= "forward" dir) (update pos :horizontal + units)))
          {:horizontal 0 :depth 0}
          directions))


(defn calc-aim-position
  [directions]
  (reduce (fn [pos [dir units]]
            (cond (= "up" dir) (update pos :aim - units)
                  (= "down" dir) (update pos :aim + units)
                  (= "forward" dir) (-> pos
                                      (update :horizontal + units)
                                      (update :depth + (* (:aim pos) units)))))
          {:horizontal 0 :depth 0 :aim 0}
          directions))

(defn part1
  [input]
  (let [{horizontal :horizontal depth :depth} (calc-position (parse input))]
    (* horizontal depth)))

(defn part2
  [input]
  (let [{horizontal :horizontal depth :depth} (calc-aim-position (parse input))]
    (* horizontal depth)))
