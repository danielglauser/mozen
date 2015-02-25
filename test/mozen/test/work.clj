(ns mozen.test.work
  (:require [clojure.test :refer :all]
            [mozen.work :refer :all]))

(def job {:data (take 10 (iterate inc 1))
          :slice-fn (partial slicer first (comp vec rest))
          :count-fn count})

(deftest test-job-processing
  (let [processed-job (process job)]
    (is (= (count (job :data))
           (count processed-job)))))
