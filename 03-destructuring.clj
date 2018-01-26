(ns clojure-basics.03-destructuring
  (:require [clojure.string :as str])
  (:require [clojure.math.numeric-tower :as math]))
;; Destructuring

;;destructuring is a convenient way to bind names to elements in a data structure
;;suppose we have a vector of 3 dimensional coordinates:
(def coords [4 12 15])
;;the long way to name each coordinate would be
(let [x (coords 0)
      y (coords 1)
      z (coords 2)]
  (+ x y z))

;;instead with destructuring
(let [[x y z] coords]
  (+ x y z))

;;this is only one type of destructuring available in clojure.
;;clojure has vector destructuring that works with lists, vectors, sequences, strings
;;there is also map destructuring for associative types

;;Here are some more general examples
(def example-vec [1 2 3 4 5])

;;example - assigning each element in a vector to a variable
(let [[a b c d e] example-vec]
  (println (str a ", " b ", " c ", " d ", " e)))

;;example - assigning one element in a vector to a variable
(let [[_ _ _ a] example-vec]
  (println a))

;;example - assigning values from a map to variables
(def example-map {:a 1 :b 2 :c 3 :d 4 :e 5})

(let [{f :a g :b h :c i :d j :e} example-map]
  (println (str f ", " g ", " h ", " i ", " j)))

;;example - in vector bindings, '&' binds the remainder of the vector to a variable
;;select what we want, and hold the rest in another variable
(let [[a b & more] example-vec]
  (println (str "this vector contains " a ", " b ", and some more " more)))

;;example - in vector bindings, :as binds the entire vectore to a variable
(let [[a b c & more :as whole-vec] example-vec]
  (println (str "pick " a ", " b " out of " whole-vec)))

;;Note: & should always come before :as
