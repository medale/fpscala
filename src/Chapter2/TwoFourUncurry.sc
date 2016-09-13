def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
  (a: A, b: B) => f(a)(b)
}


def countChar(s: String, c: Char): Int = {
  //s.filter(p => p == c).size
  s.count(p => p == c)
}

val s = "abbcccddddeeeee"

countChar (s,'d')

val uniqueChars = s.toSet

//partially applied function
val countCharsWithS = countChar(s, _: Char)

uniqueChars.foreach { c =>
  val count = countCharsWithS(c)
  println(s"Count for ${c} was ${count}")
}

def fixedSCountChar(s: String): (Char) => Int = {
  //partially applied function
  countChar(s, _: Char)
}

val countChar2 = uncurry(fixedSCountChar(_: String))

countChar2(s, 'd')







