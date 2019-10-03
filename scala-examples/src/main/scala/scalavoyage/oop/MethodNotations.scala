package scalavoyage.oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and my favourite movie is $favouriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "inceptions") // infix notation = operator notation (works only with methods with one param)

  // "operators"
  val mario = new Person("Mario", "La vita è bella")
  println(mary hangOutWith mario)

  // ALL OPERATORS ARE METHODS
  println(1.+(2))

  // prefix notation
  val x = -1 // equivalent to 1.unary_-
  val y = 1.unary_- // unary prefix only works with - + ~ !
  println(!mary)

  // postfix notation
  println(mary.isAlive)
//  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent: if the compiler sees an obj called as method then search for apply definition
}
