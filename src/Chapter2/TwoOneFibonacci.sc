import scala.annotation.tailrec

def getNthFib(n: Int): Long = {

  @tailrec def loop(currN: Int, minus1Fib: Long, minus2Fib: Long): Long = {
    val currNFib = minus1Fib + minus2Fib
    if (currN == n) {
      currNFib
    } else {
      loop(currN + 1, currNFib, minus1Fib)
    }
  }

  if (n == 1) {
    0
  } else if (n == 2) {
    1
  } else {
    loop(3, 1, 0)
  }
}

getNthFib(1)
getNthFib(2)
getNthFib(3)
getNthFib(4)
getNthFib(5)
getNthFib(6)
getNthFib(7)
getNthFib(20) //4181
getNthFib(29) //317811
