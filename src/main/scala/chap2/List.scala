package chap2

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

//companion object: Singleton, "static" methods and constants
object List {

  def apply[A](xs: A*): List[A] = {
    if (xs.isEmpty) {
      Nil
    } else {
      Cons(xs.head, apply(xs.tail: _*))
    }
  }

  def tail[A](xs: List[A]): List[A] = {
    xs match {
      case Nil => throw new RuntimeException("Cannot take tail from empty list")
      case Cons(h, t) => t
    }
  }

}

