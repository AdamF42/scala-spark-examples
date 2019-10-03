package scalavoyage.oop

object OOBasics extends App {
  val person = new PersonWithParamsFields("Rossi", 26)
  person.greet("Mario")
}

// CLASS PARAMETERS ARE NOT FIELDS
class Person(name: String, age: Int)


// constructor
class PersonWithParamsFields(name: String, val age: Int) {
  // class body: the value of the code block is ignored

  // every value in the class definition is accessible as field
  var x = 3;

  // every expression will be evaluated at every class instantiation
  //  println(1 + 2)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //multiple constructor: they can be defined only using others constructors
  def this(name: String) = this(name, 0)

  def this() = this("Giacomo")
}