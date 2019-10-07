package scalavoyage.oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType:String
    def eat(): Unit
  }

  class Dog extends Animal {
    val creatureType: String = "canine"
    def eat(): Unit = println("crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal):Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    override def eat(): Unit = println("gnam")

    override def eat(animal: Animal): Unit = println("I'm a crock and I'm eating S{animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile

  crocodile.eat(dog)

  // traits vs abstract
  // 1. traits do not have constructor parameters
  // 2. multiple treats may be inherited by the same class
  // 3. traits = behaviour, abstract class = "things"


}
