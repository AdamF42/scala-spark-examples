package scalavoyage.oop

object Inheritance extends App {

  val cat = new Cat
  val dog = new Dog("domestic")
  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  cat.crunch()

  // single class inheritance
  class Animal {
    val creatureType = "wild"

    def eat(): Unit = println("gnam")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("crunch")
    }
  }

  // overriding

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)
  dog.eat()
  println(dog.creatureType)

  //  class Dog(override val creatireType: String) extends Animal {
  class Dog(dogType: String) extends Animal {
    //    override val creatureType: String = "domestic"

    override val creatureType: String = dogType

    override def eat(): Unit = {
      super.eat()
      println("crunch, crunch")
    }
  }
  unknownAnimal.eat() // calls Dog eat method

  // preventing overrides
  // 1 - using keyword final on member of superclass
  // 2 - using final on the entire class
  // 3 - seal the class (sealed) = extend classes in this file but prevent extension in other files
}
