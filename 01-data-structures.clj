;;to start a REPL run $ lein repl
;;to create a a new project run $ lein new project-name
;;dependencies and other information go in project.clj (lein fetches dependencies automatically)
;;source code goes in src/project-name
;;to run a project, from the project directory do $ lein run
;;to start a gorilla notebook, add :plugins [[lein-gorilla "0.4.1"]] to project.clj and run $ lein gorilla from the project directory


;;namespace, importing dependencies
(ns clojure-basics.01-data-structures
  (:require [clojure.string :as str])
  (:require [clojure.math.numeric-tower :as math]))
;;namespace has the several other options
;; (:require ...)
;; (:import ...)
;; (:use ...)
;; (:refer-clojure ...)
;; (:gen-class ...)
;;mathematical operations use prefix notation
(+ 1 2)
(- 2 1)
(* 3 2)
(/ 2 3)e
(/ 2.0 3)
(quot 3 2)
(rem 2 2)
(inc 2)
(dec 5)
(min 5 6 18)
(max 5 6 18)
;;calling imported function
(math/sqrt 25)
(math/expt 2 3)
(+ 5 (* 5 (- 7 2 1)))


;;let makes a new lexical scope with the included bindings
(let [width     10
      height    20
      thickness 2]
  (println "hello from inside the `let`.")
  (* width height thickness))

(let [x 2
      x (* x x)
      x (+ x 1)]
  x)

;;primitive types in clojure (also printing)

;;literals for BigInt and BigDecimal are specified using a postfix N and M respectively
(println "Scalars: \n")
(println "Type of 1 is: " (type 1) "\n")
(println "Type of 1.2 is: " (type 1.2) "\n")
(println "Type of 1N is: " (type 1N) "\n")
(println "Type of 1.5M is: " (type 1.5M) "\n")
(println "Type of 1.2e4 is: " (type 1.2e4) "\n")
(println "Type of 1/3 is: " (type 1/3) "\n")
(println "Type of \"HEY!\" is: " (type "HEY!") "\n")
(println "Type of \\a is: " (type \a) "\n")
(println "Type of :my-keyword is: " (type :my-keyword) "\n")
(println "Type of 'my-s is: " (type 'my-s) "\n")
(println "Type of true is: " (type true)"\n")
(println "Type of true is: " (type true)"\n")
(println "Type of nil is: " (type nil)"\n")

;;Note: using def creates a variable binding

;;collection data structures

;; Vectors
;; Square brackets. Elements callable by index. conj adds an item to the end of the vector
(def v [:a :b :c])
(conj v :d)
(type v)
(nth v 1)
(v 2)
(first v)
(rest v)
(next v)
(last v)

;; Lists
;;creation requires tick marks to differentiate from function calls
;;lists can't be indexed. conj adds an item to the front of the list. peek/pop stack-like structure
(def l '(a b c))
(type l)
(conj l 'd)

;; Maps
(def m {:a 1 :b 2})
(type m)
(get m :a)
(m :a)
(:a m)
(get m :x 44)         ; ⇒ 44      (if no :x, 44 is the default)
(keys m)
(vals m)
;;get a key or a val from a single map entry (maps are not ordered):
(key (first m))       ; ⇒ :a
(val (first m))       ; ⇒ 1
;;adding key, value pairs
(assoc m :c 3)
(dissoc m :b)

;; Sets
;;only contain unique entries
(def s #{:a :b :c})
(type s)
(s :a)
(s :z)
(disj s :a)

;;functions for creating data structures
(list 1 2 3)
(vector 1 2 3)
(hash-map :a 1 :b 2)
(hash-set :a :b :c)

;;converting types
(def my-vec [1 2 3])
(set my-vec)

(def my-list '(1 2 3))
(vec my-list)

(def my-map {:a 1 :b 2 :c 3})
(vec my-map)
(flatten (vec my-map))
(set my-map)

(def my-set #{:a :b :c})
(vec my-set)

;;create hash-map from vectors
(zipmap [:a :b :c] [1 2 3])
(apply hash-map [:a 1 :b 2])

;; Strings and basic manipulations
(str "hello" "world")
(def my_string "hello")
(println my_string)
(str/split "hello world" #" ")
(str/join ["hello" "world"])
(str/replace "hello world" "ll" "LL")
;;strings can be treated sequentially
(first "hello")
(rest "hello")
(nth "hello" 1)
(doseq [letter "hello"] (println letter))
