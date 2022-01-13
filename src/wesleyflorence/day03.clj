(ns wesleyflorence.day03
  (:require [clojure.string :as str]))

(defn parse
  [input]
  (->> input
         (str/split-lines)
         (map (fn [line]
                (map #(Character/digit % 2)
                     line)))))

(defn build-count-list
  [diagnostic]
  (reduce #(map + %1 %2) diagnostic))

(defn find-gamma-binary
  [diagnostic]
  (let [length (/ (count diagnostic) 2)
        counted (build-count-list diagnostic)]
    (map #(if (> % length) 1 0) counted)))

(defn find-gamma
  [diagnostic]
   (Integer/parseInt (apply str (find-gamma-binary diagnostic)) 2))

(defn find-epsilon
  [diagnostic]
   (Integer/parseInt (apply str (map #(* (- % 1) -1) (find-gamma-binary diagnostic))) 2))

(defn run-diagnostic
  [diagnostic]
  (* (find-gamma diagnostic) (find-epsilon diagnostic)))

(defn part1
  [input]
  (run-diagnostic (parse input)))

(defn part2
  [input]
  (str "not done"))
