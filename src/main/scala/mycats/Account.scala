package mycats

import cats._
import cats.implicits._

final case class Account(id: Long, number: String, balance: Int, owner: String)

object Account {

    implicit val universalEq: Eq[Account] = Eq.fromUniversalEquals[Account]

    object Instances {
        implicit def byId(implicit eqLong: Eq[Long]): Eq[Account] = Eq.by(_.id)
        implicit def byNumber(implicit eqStr: Eq[String]): Eq[Account] = Eq.by(_.number)
    }

    def main(args: Array[String]): Unit = {
        val a1 = Account(1, "122", 100, "me")
        val a2 = Account(1, "123", 100, "me")
        val a3 = Account(2, "123", 100, "me")

        val result = a1.eqv(a2)
        println(result)
        println(a1 === a2)

        println(Instances.byId.eqv(a1,a2))
        println(a2 === a3)
    }
}

object Bar {
    def main(args: Array[String]): Unit = {
      implicit val toUse = Account.Instances.byNumber
      val a1 = Account(1, "122", 100, "me")
      val a2 = Account(1, "123", 100, "me")
      val a3 = Account(2, "123", 100, "me")

      println(a1 === a2)
      println(a2 === a3)
    }
}