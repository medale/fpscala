def compose[A,B,C](f: B => C, g: A => B): A => C = {
  (a: A) => f(g(a))
}

type Gender = String
type Risk = Double
case class Consumer(ssn: String, gender: Gender, age: Int)

/*
  * Evaluate risk: if digits of SSN add up to even number, risk is 0 ;-)
  */
def evaluateRisk(c: Consumer):Risk = {
  val digits = c.ssn.filter(p => p.isDigit)
  val sum = digits.sum
  sum % 2
}

def giveLoan(r: Risk): Boolean = {
  if (r < 0.5) {
    true
  }  else {
    false
  }
}

val digits = "111-222-3334".filter(p => p.isDigit).map(c => c.asDigit)
val sum1 = digits.reduce(_ + _)
val sum2 = digits.sum

//http://alvinalexander.com/java/jwarehouse/scala-2.11/library/scala/Predef.scala.shtml
//@inline implicit def augmentString(x: String): StringOps = new StringOps(x)
//http://www.scala-lang.org/api/current/#scala.collection.immutable.StringOps
//http://www.scala-lang.org/api/current/#scala.runtime.RichChar
val digits2 ="111-222-3334".filter(p => p.isDigit)
val sum = digits.sum

val c1 = Consumer("111-11-1111", "M", 42)
evaluateRisk(c1)

val c2 = Consumer("111-11-1112", "M", 42)
evaluateRisk(c2)

val giveLoanPred = compose(giveLoan, evaluateRisk)
giveLoanPred(c1)
giveLoanPred(c2)

//built-in Fucntion1
val giveLoanPred2 = evaluateRisk _ andThen giveLoan _
giveLoanPred2(c1)
giveLoanPred2(c2)

//built-in
val giveLoanPred3 = giveLoan _ compose evaluateRisk _
giveLoanPred3(c1)
giveLoanPred3(c2)


