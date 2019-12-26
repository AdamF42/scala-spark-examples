package scalavoyage.oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Ahahahahahahah")
  }

  /*
  The compiler does something like:

  class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("Ahahahahahahah")
  }

  val funnyAnimal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHello: Unit = println(s"Hi, I'm $name")
  }

  val adam = new Person("Adam") {
    override def sayHello: Unit = super.sayHello
  }


  


}
