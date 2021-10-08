package chap6funcstate

trait Rng {
  type Rand[+A] = Rng => (A, Rng)

  def nextInt: (Int, Rng)

  val int: Rand[Int] = _.nextInt
}

case class SimpleRng(seed: Long) extends Rng {
  def nextInt: (Int, Rng) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFFL
    val nextRng = SimpleRng(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRng)
  }
}

object RNG {

  def main(args: Array[String]): Unit = {
    var rng: Rng = SimpleRng(10)
    (1 to 12).foreach { _ =>
      val rand = rng.int
      val (num, nextRng) = rand(rng)
      println(num)
      rng = nextRng
    }
  }
}
