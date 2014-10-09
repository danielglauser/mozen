(ns mozen.core)

(def execution-schemes
  {:local-parallel
   {:desc "Execute the worker function parallelized over multiple cores."}
   :remote-parallel
   {:desc "Execute the worker function parallelized over multiple nodes"
    :group-by {:fn identity
               :desc "Function for determining how to group the execution"}}
   :serial
   {:desc "Local execution in order."}})

(defn work
  "A coarse grained unit of work in the system. It is defined by a
  data structure called coll that is sliced into pieces by a
  slice-fn (slice-fn coll) -> [p1 p2 p3...] meant to be digested by
  the work-fn (map work-fn [p1 p2 p3...]) "
  [coll slice-fn work-fn slice-error-fn & [advice answers]]
  {:collection coll :slice-fn
   slice-fn :work-fn work-fn
   :slice-error-fn slice-error-fn
   :advice advice :answers answers})

(def simple-job
  [{:coll (range 20)
    :slice-fn identity
    :slice-error-fn println
    :work-fn inc
    :work-error-fn println
    :advice :serial}])

(defn job
  "Take a collection of work and tries to complete it."
  [work-coll])
