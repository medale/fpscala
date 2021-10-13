package mycats

import cats._
import cats.implicits._

final case class Account(id: Long, number: String, balance: Int, owner: String)

object Account {

    implicit val universalEq: Eq[Account] = Eq.fromUniversalEquals[Account]
    implicit def orderById(implicit orderLong: Order[Long]): Order[Account] = Order.from((a1, a2) => orderLong.compare(a1.id, a2.id))
    
    object Instances {
        implicit def eqById(implicit eqLong: Eq[Long]): Eq[Account] = Eq.by(_.id)
        implicit def eqByNumber(implicit eqStr: Eq[String]): Eq[Account] = Eq.by(_.number)
        implicit def orderByBalance(implicit orderInt: Order[Int]): Order[Account] = Order.by(a => a.balance)
        implicit def orderByBalanceDesc(implicit orderInt: Order[Int]): Order[Account] = Order.reverse(orderByBalance)
    }

    def sort[A](list: List[A])(implicit order: Order[A]): List[A] = {
        list.sorted(order.toOrdering)
    }

    def main(args: Array[String]): Unit = {
        val a1 = Account(1, "122", 100, "me")
        val a2 = Account(1, "123", 300, "me")
        val a3 = Account(2, "123", 250, "me")

        val result = a1.eqv(a2)
        println(result)
        println(a1 === a2)

        println(Instances.eqById.eqv(a1,a2))
        println(a2 === a3)

        val l = List(a3, a2, a1)
        println(Account.sort[Account](l)(Instances.orderByBalance).mkString(","))
        println(Account.sort[Account](l)(Account.orderById).mkString(","))

        println(a3.compare(a1))
        println(a1 max a3)
    }
}

object Bar {
    def main(args: Array[String]): Unit = {
      implicit val toUse = Account.Instances.eqByNumber
      val a1 = Account(1, "122", 100, "me")
      val a2 = Account(1, "123", 100, "me")
      val a3 = Account(2, "123", 100, "me")

      println(a1 === a2)
      println(a2 === a3)
    }
}