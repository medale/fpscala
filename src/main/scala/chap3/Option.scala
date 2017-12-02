package chap3

//hide std library `Option` and `Either`
import scala.{Option => _, Either => _}

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = {
    this match {
      case Some(a) => Some(f(a))
      case None => None
    }
  }
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]