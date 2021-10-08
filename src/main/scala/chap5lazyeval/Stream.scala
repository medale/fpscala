package chap5lazyeval

import Stream._

sealed trait Stream[+A] {

  def exists(p: A => Boolean): Boolean = this match {
    case Cons(h, t) => p(h()) || t().exists(p)
    case _ => false
  }

  def drop(n: Int): Stream[A] = {
    this match {
      case Cons(_, t) if n > 0 => t().drop(n - 1)
      case c@Cons(_, _) if n == 0 => c
      case _ => empty
    }
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B = {
    this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f))
      case _ => z
    }
  }

  def forAll(p: A => Boolean): Boolean = {
    this.foldRight(true)((h, t) => p(h) && t)
  }

  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(h, _) => Some(h())
  }

  def headOption_1: Option[A] = {
    val z: Option[A] = None
    this.foldRight(z) { (h, _) =>
      Some(h)
    }
  }

  def take(n: Int): Stream[A] = {
    this match {
      case Cons(h, t) if n > 0 => cons(h(), t().take(n - 1))
      case Cons(h, _) if n == 1 => cons(h(), empty)
      case _ => empty
    }
  }

  def toList: List[A] = this match {
    case Empty => List.empty
    case Cons(h, t) => List(h()) ++ t().toList
  }

  def takeWhile(p: A => Boolean): Stream[A] = {
    this.foldRight(empty[A]) { (h, soFar) =>
      lazy val head = h
      if (p(head)) cons(head, soFar) else soFar
    }
  }

  def map[B](f: A => B): Stream[B] = {
    this.foldRight(empty[B]) { (h, soFar) =>
      cons(f(h), soFar)
    }
  }
}

case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] = {
    if (as.isEmpty) {
      empty
    } else {
      cons(as.head, Stream(as.tail: _*))
    }
  }

  def from(n: Int): Stream[Int] = {
    Stream.cons(n, from(n + 1))
  }

  def main(args: Array[String]): Unit = {
    val s = cons(2, cons(4, cons(5, cons(6, empty))))
    val m = s.map(i => i * 2)
    println(m.toList)

    /*val t = s.takeWhile(_ % 2 ==0)
    println(t.toList)

    val hOpt = s.headOption_1
    val iOpt = empty.headOption_1
    println(iOpt)*/

    val s2 = from(2)
    println(s2.take(5).toList)
  }
}