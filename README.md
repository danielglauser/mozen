# Mozen
מאזן - Mozen a library for balancing the distribution of work

=======================

## Mission

You have four nodes with four processors each. What is the most
efficient way to distribute your workload across these nodes? Does it
make sense to distribute the work? What if you knew a spike was coming
and someone gave you twenty more nodes? How about five hundred? Would
you know what to do? Should you know what to do?

Mozen is an experiment where by describing your workloads with the
following form we let the library figure out how to distribute the
work for you.

Functional programming has greatly helped with problems of scope,
simplicity, and factoring of modern software. However, we believe that
declarative work is better than perscriptive functions describing the
work, it's time to train machines to figure out how to optimize our
software jobs and react to the available hardware resources. It's very
hard for a programmer to write software that can adjust the factors
it's optimized for. We feel that if we do a better job describing the
problem that needs to be solved and the data used to solve it the
system can optimize the execution for fast, good, or inexpensive, much
better than we can.

### Batch Processing

Due to latency spinning up and down nodes, moving processes and code
onto nodes, and generally distributing work we're going to first focus
on batch processing. Batch jobs tend to be computationally intensive
and take a while to complete and often benefit more from
parallelization and distribution than workloads that require low
latency. Some good examples are training models, neural networks,
video encoding, general large scale data transformation.

## Work

Let's start with a definition of work. In a functional program work
can be described as a pure function with its arguments. In Mozen we'll
do something similar but add in a few addtional pieces to make it
easier for the system to determine the optimal way to execute the
work.

Work is:

{:data ...
 :slice-fn ...
 :process-fn ...
 :error-fn ...}

 data - Any data structure.
 slice-fn - A function that gets you the next element of the data structure.
 process-fn - A function that does the work for one slice.
 error-fn - A function that handles errors in the process-fn.

## License

Copyright © 2020 Daniel Glauser

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
