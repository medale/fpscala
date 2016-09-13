def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
  (a: A) => ((b : B) => f(a,b))
}

def countChar(s: String, c: Char): Int = {
  //s.filter(p => p == c).size
  s.count(p => p == c)
}

countChar ("abbcccdddd", 'd')

val s = "abbcccddddeeeee"

//http://alvinalexander.com/java/jwarehouse/scala-2.11/library/scala/Predef.scala.shtml
//@inline implicit def augmentString(x: String): StringOps = new StringOps(x)
//http://www.scala-lang.org/api/current/#scala.collection.immutable.StringOps
val uniqueChars = s.toSet

val curriedCountChar = curry(countChar)

val curriedCountCharWithS = curriedCountChar(s)

val charCountPairs = uniqueChars.map { c =>
  val charCount = curriedCountCharWithS(c)
  (c, charCount)
}.toSeq

//http://www.lorrin.org/blog/2011/10/04/scalas-missing-splat-operator/
val charCountMap = Map(charCountPairs: _*)







