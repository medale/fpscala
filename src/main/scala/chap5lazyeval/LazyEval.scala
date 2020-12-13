package chap5lazyeval

import Stream._

object LazyEval {

  //call by name, thunks
  def if2[A](cond: Boolean, onTrue: () => A, onFalse: () => A): A =  {
    if (cond) {
      onTrue()
    } else {
     onFalse()
    }
  }

  def expensive(i: Int): Long = {
    println(s"Now sleeping")
    Thread.sleep(1000)
    i * 1000
  }

  def main(args: Array[String]): Unit = {
    val test = (s: String) => s.isBlank
    if2(test("jkkj"), () => println("True"), () => println("False"))

    //prints now sleeping twice - recomputes expensive for each call
    //val s = Cons(() => expensive(1), () => empty[Long])
    //s.headOption
    //s.headOption

    //smart constructor with lazy val only call expensive the first time, then caches value
    //val s1 = cons(expensive(2), empty)
    //s1.headOption
    //s1.headOption

    val s2 = cons(expensive(2), cons(expensive(3), empty))
    println(s2)
    //val l2 = s2.toList
    //println(l2)

    val s3 = Stream(1, 2, 3, 4, 5, 6)
    val s32 = s3.take(2)
    val l32 = s32.toList
    println(l32)

    val s3d3 = s3.drop(3)
    println(s3d3.toList)
  }
}
