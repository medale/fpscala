package chap3

import common.UnitTest

class OptionTest extends UnitTest {

  describe("Functions that use Options") {
    it("should return Some or None") {
      val emptyList = Nil
      val nonEmptyList = "a" :: "b" :: Nil

      val res1 = emptyList.headOption
      res1 should be(None)

      val res2 = nonEmptyList.headOption
      res2 should be(Some("a"))
    }
  }

}
