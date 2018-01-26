(ns clojure-basics.02-logic-functions
  (:require [clojure.string :as str])
  (:require [clojure.math.numeric-tower :as math]))

;; Logic and Conditionals

;;'if' is a special form in closure with syntax (if <condition> <do-this> <else-this>)
;;in evaluating conditionals, clojure resolves nil and false as falsey, everything else as truthy

(if   0 :t :f)
(if  "" :t :f)
(if  [] :t :f)
(if  {} :t :f)
(if #{} :t :f)
(if nil :t :f)
(if false :t :f)

;;the following idiom can be use to test if a sequence is empty
(if (seq [1 2]) "not empty" "empty")
(if (seq {}) "not empty" "empty")
;;or using a predicate
(empty? [])
(empty? '(1 2))

;; = is a function that recursively checks equality of nested structures
;; = considers lists and vectors with matching values to be the same
;;order matters for lists and vectors, not for maps and sets
(= {:a  [1 2 3] :b #{:x :y} :c {:foo 1 :bar 2}}
   {:a '(1 2 3) :b #{:y :x} :c {:bar 2 :foo 1}})
(= '(1 2 3) [1 3 2])
(= #{:x :y} #{:y :x})
;;Note: clojure has nice rational number properties using the Ratio type
(= 3/7 9/21)
;;single = is strict regarding types
(= 0 0.0)
;;double == is more forgiving
(== 0 0.0)

;;clojure also contains the logical operators 'and', 'or', 'not' , >, >=, <, <=, =, ==, and 'not='
(not= 2 3)
(>= 3 1)
(and (> 2 1) (< 2 1))
(not (or (> 2 1) (< 2 1)))

;;Note: clojure has another special form similar to if called cond that will be discussed later
;;cond is used when testing multiple conditional statements (similar to elif or else if from other languages)

;;predicates are functions that test an input and return true or false
;;predicates usually end in question marks
(even? (+ 2 3))
(rational? (+ 2 3))
(nil? (+ 2 3))
;;many existing clojure functions can be used as predicates

;; Functions

;;fn is used for creating anonymous (maybe named) functions (fn name? [params*] exprs*)
;;fn takes in a vector of parameters
(fn [x] (* x x))
;;they can be called immediately
((fn [x] (* x x))2)
;;fn is most often used to create anonymous functions inside other function calls
(map (fn [x] (* x x)) (range 1 10))
;;passing a name into fn is useful in that the name will appear in an error message if there is a problem
(fn square [x] (* x x))
;;WARNING: trying to call square with (square 2) outside the fn will cause an error

;;we could use the following to name a function
(def squared
  (fn [x] (* x x)))
(squared 2)

;;using defn is more convenient for creating top level functions
(defn cubed
  "Add a docstring to make your code readable and reuseable. This function cubes the input."
  [x]
  (* x x x))

(cubed 2)

;;example using cond (as noted earlier)
(defn hows-the-weather
  "Decide how you feel about the temperature"
  [temp]
  (cond
    (< temp 45) "That's pretty cold."
    (and (>= temp 45) (<= temp 65)) "It's sweater time."
    (> temp 66) "Warming up."))

(hows-the-weather 60)
