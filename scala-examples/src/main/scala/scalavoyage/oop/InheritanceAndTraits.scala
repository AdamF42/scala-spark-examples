package scalavoyage.oop

object InheritanceAndTraits extends App {

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

  val cat = new Cat
  cat.crunch()


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding

  //  class Dog(override val creatireType: String) extends Animal {
  class Dog(dogType: String) extends Animal {
    //    override val creatureType: String = "domestic"

    override val creatureType: String = dogType

    override def eat(): Unit = println("crunch, crunch")
  }

  val dog = new Dog("domestic")
  dog.eat()
  println(dog.creatureType)


  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat() // calls Dog eat method

}
