package scalavoyage.oop

object Object extends App {

  // Scala Object = SSINGLETON INSTANCE
  val mary = Person
  val jhon = Person

  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)
  val laura = new Person("Laura")
  val filippo = new Person("Filippo")
  println(mary == jhon) //points to the same instance
  val test = Person(laura, filippo)

  class Person(val name: String) {
    // instance-level functionality
  }
  println(laura == filippo) // different obj

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality

    val N_EYES = 2

    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  // Scala Applications = scala obj with main(args: Array[String]):Unit

}
