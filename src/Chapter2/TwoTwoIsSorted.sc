import annotation.tailrec

def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {

  @tailrec def loop(i: Int): Boolean = {
    if (i >= as.size - 1) {
      true
    } else {
      val a1 = as(i)
      val a2 = as(i + 1)
      if (ordered(a1, a2)) {
        loop(i + 1)
      } else {
        false
      }
    }
  }

  loop(0)
}

val a = Array("a", "b", "c")
val ord = (a1: String, a2: String) => a1 <= a2

isSorted(a, ord)

val b = Array("b", "c", "a")
isSorted(b, ord)

