package scalavoyage.oop

object Object extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality

    val N_EYES = 2

    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person (val name:String){
    // instance-level functionality
  }

  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala Object = SSINGLETON INSTANCE
  val mary = Person
  val jhon = Person
  println(mary==jhon) //points to the same instance

  val laura = new Person("Laura")
  val filippo = new Person("Filippo")
  println(laura==filippo) // different obj

  val test=Person(laura,filippo)

  // Scala Applications = scala obj with main(args: Array[String]):Unit

}
