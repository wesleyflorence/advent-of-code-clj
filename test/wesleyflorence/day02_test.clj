(ns wesleyflorence.day02-test
  (:require [wesleyflorence.day02 :as sut]
            [wesleyflorence.advent-of-code-clj :as core]
            [clojure.test :refer :all]))

(deftest test-part1
  (testing "Part 1"
    (is (= 150 (sut/part1 (core/read-in "day02" ".test"))))))

(deftest test-part2
  (testing "Part 2"
    (is (= 900 (sut/part2 (core/read-in "day02" ".test"))))))
