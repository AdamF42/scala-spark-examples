package scalavoyage.oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. case classes promote all parameters as fields
  val adam = new Person("Adam", 25)
  println(adam.name)

  // 2. Easy debugging
  println(adam.toString) // equal to println(adam)

  // 3. equals and hashCode implemented out of the box
  val adam2 = new Person("Adam", 25)
  println(adam == adam2)
  println(adam equals adam2)

  // 4. Case Classes have handy copy method
  val adam3 = adam2.copy(age = 26)

  // 5. Case Classes have companion objects
  val thePerson = Person
  val mary = Person.apply("Mary", 33)

  // 6. Case Classes are serializable

  // 7. Case Classes have extractor patterns = Case Classes can be used in PATTERN MATCHING

  case object Itay {
    def name: String = "Italy is beautiful"
  }
}
