import annotation.tailrec

def findFirst[T](a: Array[T], f: (T) => Boolean): Int = {

  @tailrec def loop(currIndex: Int): Int = {
    if (currIndex >= a.size) {
      -1
    } else {
      val currT = a(currIndex)
      if (f(currT)) {
        currIndex
      } else {
        loop(currIndex + 1)
      }
    }
  }

  loop(0)
}

val foo = Array("foo", "bar", "baz")

findFirst(foo, (x: String) => x == "baz")
findFirst(foo, (x: String) => x == "barbaz")

val bar = Array(1,2,5,7,5)

findFirst(bar, (x: Int) => x % 2 == 0)

val ff = findFirst _





