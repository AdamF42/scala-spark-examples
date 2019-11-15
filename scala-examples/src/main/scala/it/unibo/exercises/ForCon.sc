import Math.sqrt


def isPrime(n: Int): Boolean =
  (2 to sqrt(n.toDouble).toInt forall (d => (n % d != 0)))

(1 to 20) flatMap (i => (1 to i) map (j => (i, j))) filter
  (pair => isPrime(pair._1 + pair._2))


for {
  i <- 1 to 20
  j <- 1 to i
  if isPrime(i + j)
} yield (i, j)

def scalaProduct2(xs: Vector[Double],
                  ys: Vector[Double]): Double =
  (for ((x, y) <- xs zip ys) yield x * y).sum


case class Book(title: String, authors: List[String])

val books: List[Book] = List(
  Book(
    title = "Structure and Interpretation of Computer Programs",
    authors = List("Abelson, Harald", "Sussman, Gerald J.")),
  Book(
    title = "Introduction to Functional Programming",
    authors = List("Bird, Richard", "Wadler, Phil")),
  Book(
    title = "Effective Java",
    authors = List("Bloch, Joshua", "Bird, Pinco" , "Bird, Pallino")),
  Book(
    title = "Java Puzzlers",
    authors = List("Bloch, Joshua", "Gafter, Neal")),
  Book(title = "Programming in Scala",
    authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
)

// Books edited by Bird
for {
  b <- books
  a <- b.authors
  if a startsWith "Bird,"
} yield b // yield generates the element I want in resulting collection
//NOTE: the type of resulting case class case class collection is the same as the first


// Books containing the string "Program" in the title
for {
  b <- books
  if b.title contains "Program"
} yield b

abstract class Perhaps[+A] {
  def foreach(f:A=>Unit):Unit
}


//def queens(n: Int) = {
//
//  def placeQueens(k:Int):Set[Vector[Int]] = {
//    if (k==0) Set(Vector())
//    else
//      for {
//        queens <- placeQueens(k-1)
//        col <- 0 unitl n
//        if isSafe(col, queens)
//      } yield queens :+ col
//  }
//  placeQueens(n)
//}

//def isSafe(col: Int, queens: Vector[Int]):Boolean ={
//  val row = queens.length
//
//}

