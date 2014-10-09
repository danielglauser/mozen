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

Copyright © 2014 Daniel Glauser

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
