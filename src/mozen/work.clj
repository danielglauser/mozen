(ns mozen.work)

(defn slicer [first-fn rest-fn job]
  (let [data (:data job)
        element (first-fn data)
        remaining (rest-fn data)]
    (assoc job :element element :data remaining)))

(defn slice [{:keys [slice-fn] :as job}]
  (slice-fn job))

(defn process
  "Work through the entire job."
  [job]
  (let [count-fn (:count-fn job)
        size (count-fn (:data job))]
    (take size (iterate slice job))))
