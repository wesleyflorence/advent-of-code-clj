(ns wesleyflorence.day01-test
  (:require [wesleyflorence.day01 :as sut]
            [wesleyflorence.advent-of-code-clj :as core]
            [clojure.test :refer :all]))

(deftest test-part1
  (testing "Part 1"
    (is (= 7 (sut/part1 (core/read-in "day01" ".test"))))))

(deftest test-part2
  (testing "Part 2"
    (is (= 5 (sut/part2 (core/read-in "day01" ".test"))))))
