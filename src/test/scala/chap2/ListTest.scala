package chap2

import common.UnitTest

class ListTest extends UnitTest {

  describe("List.apply") {
    it("empty seq should return Nil") {
      val res = chap2.List()
      assert(res === Nil)
    }
    it("one element should return Cons(x, Nil)") {
      val res = chap2.List("one")
      assert(res === Cons("one", Nil))
    }
    it("two elements should return Cons(x, Cons(y, Nil))") {
      val res = chap2.List("one", "two")
      assert(res === Cons("one", Cons("two", Nil)))
    }
  }

  describe("List.tail") {
    it("empty list should throw Exception") {
      //also assertThrows[RuntimeException]
      val caught =
        intercept[RuntimeException] {
          List.tail(Nil)
        }
      assert(caught.getMessage.contains("empty"))
    }
    it("one item Cons should return Nil") {
      val tail = Nil
      val res = List.tail(Cons("one", tail))
      assert(res === tail)
    }
    it("two items Cons should return one item Cons") {
      val tail = Cons("two", Nil)
      val res = List.tail(Cons("one", tail))
      assert(res === tail)
    }
  }

}
