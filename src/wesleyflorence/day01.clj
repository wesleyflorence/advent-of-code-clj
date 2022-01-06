(ns wesleyflorence.day01
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (->> input
         (str/split-lines)
         (map #(Integer/parseInt %))))


(defn sum-optional-list
  [in]
  (if (seq? in)
    (reduce + in)
    in))

(defn scan-depth
  ([depths window] (scan-depth depths window 0))
  ([depths window acc]
   (let [frs (take window depths)
         sec (take window (rest depths))]
     (if (< (count sec) window)
       acc
       (if (< (sum-optional-list frs) (sum-optional-list sec))
         (recur (rest depths) window (inc acc))
         (recur (rest depths) window acc))))))

(defn part1
  [input]
  (scan-depth (parse input) 1))

(defn part2
  [input]
  (scan-depth (parse input) 3))
