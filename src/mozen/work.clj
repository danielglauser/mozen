(ns mozen.work)

(defn slicer [first-fn rest-fn job]
  (let [data (:data job)
        element (first-fn data)
        remaining (rest-fn data)]
    (assoc job :element element :data remaining)))

(defn slice [{:keys [slice-fn] :as job}]
  (slice-fn job))

(defn process [job]
;; TODO: Can we do this without a count-fn?
  (let [count-fn (:count-fn job)
        size (count-fn (:data job))]
    (take (+ size 1) (iterate slice job))))

(def job {:data [1 2 3 4 5 6 7 8 9 10]
          :slice-fn (partial slicer first (comp vec rest))
          :count-fn count})
