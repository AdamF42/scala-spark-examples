package scalavoyage.oop

object MethodNotations extends App {

  val mary = new Person("Mary", "Inception")
  // "operators"
  val mario = new Person("Mario", "La vita è bella")
  println(mary.likes("Inception"))
  println(mary likes "inceptions") // infix notation = operator notation (works only with methods with one param)
  // prefix notation
  val x = -1 // equivalent to 1.unary_-
  println(mary hangOutWith mario)

  // ALL OPERATORS ARE METHODS
  println(1.+(2))
  val y = 1.unary_- // unary prefix only works with - + ~ !

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie)

    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and my favourite movie is $favouriteMovie"
  }
  println(!mary)

  // postfix notation
  println(mary.isAlive)
  //  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent: if the compiler sees an obj called as method then search for apply definition
}
