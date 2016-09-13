//Paste the code from the following URL to scala console
//https://raw.githubusercontent.com/fpinscala/fpinscala/master/answers/src/main/scala/fpinscala/datastructures/List.scala

import List._
val x = List(1,2,3,4,5) match {
  case Cons(x, Cons(2, Cons(4, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  case Cons(h, t) => h + sum(t)
  case _ => 101
}