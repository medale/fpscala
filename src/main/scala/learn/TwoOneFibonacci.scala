package learn

import scala.annotation.tailrec

object TwoOneFibonacci {

  def getNthFib(n: Int): Long = {

    @tailrec def loop(currN: Int, minus1Fib: Long, minus2Fib: Long): Long = {
      val currNFib = minus1Fib + minus2Fib
      if (currN == n) {
        currNFib
      } else {
        loop(currN + 1, currNFib, minus1Fib)
      }
    }
    loop(1, 1, 0)
  }
}
