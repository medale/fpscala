package chap2

import common.UnitTest

class ListTest extends UnitTest {

  "List.apply with empty seq" must "return Nil" in {
    val res = chap2.List()
    assert(res === Nil)
  }

  "List.apply with one element" must "return Cons(x, Nil)" in {
    val res = chap2.List("one")
    assert(res === Cons("one", Nil))
  }

  "List.apply with two elements" must "return Cons(x, Cons(y, Nil))" in {
    val res = chap2.List("one", "two")
    assert(res === Cons("one", Cons("two", Nil)))
  }

  "List.tail with empty list" must "throw Exception" in {
    //also assertThrows[RuntimeException]
    val caught =
      intercept[RuntimeException] {
        List.tail(Nil)
      }
    assert(caught.getMessage.contains("empty"))
  }

  "list.tail with one item Cons" must "return Nil" in {
    val tail = Nil
    val res = List.tail(Cons("one", tail))
    assert(res === tail)
  }

  "List.tail with two items Cons" must "return one item Cons" in {
    val tail = Cons("two", Nil)
    val res = List.tail(Cons("one", tail))
    assert(res === tail)
  }

}
