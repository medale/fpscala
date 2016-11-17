import scala.annotation.tailrec

val l = List(4,1,5,6)

l.foldRight(0)((curr, acc) => acc + 1)

def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {

  @tailrec def loop(bs: List[A], acc: B): B = {
    bs match {
      case Nil => acc
      case x :: xs => loop(xs, f(acc, x))
    }
  }

  loop(as, z)
}

def sum[T <: Numeric[T]](l: List[T]): T = {
  foldLeft(l, )((acc, curr) => curr.plus(acc, curr))
}


