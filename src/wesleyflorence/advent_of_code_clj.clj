(ns wesleyflorence.advent-of-code-clj
  (:gen-class)
  (:require [clojure.java.io :as io]
            [wesleyflorence.day03 :as day03]
            [wesleyflorence.day02 :as day02]
            [wesleyflorence.day01 :as day01]))

(defn read-in
  ([day] (read-in day ".input"))
  ([day ext]
  (slurp (io/resource (str day ext)))))

(defn -main
  "Solve each day"
  [& days]
  (doseq [day days]
    (case day
      "day03" (do
                (println (day03/part1 (read-in day)))
                (println (day03/part2 (read-in day))))
      "day02" (do
                (println (day02/part1 (read-in day)))
                (println (day02/part2 (read-in day))))
      "day01" (do
                (println (day01/part1 (read-in day)))
                (println (day01/part2 (read-in day))))
      (println day "is not solved yet"))))
