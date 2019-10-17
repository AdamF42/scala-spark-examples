package scalavoyage.oop

object Generics extends App {

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  val trainer: Trainer[Cat] = new Trainer[Animal]
  val cage = new Cage(new Dog)
  //val newCage = new Cage(new Car) // will not work

  class MyList[+A] {

    def add[B >: A](elem: B): MyList[A] = ???

    /*
      A = Cat
      B = Animal
     */

  }

  class MyMap[key, Value]

  // variance problem
  class Animal

  // animalList.add(new Dog) will turn a list of cat in something more generic as a list of Animal

  class Cat extends Animal

  class Dog extends Animal

  // val invariantAnimalList2: InvariantList[Animal] = new InvariantList[Cat]

  // 1. COVARIANCE List[Cat] extends List[Animal]
  class CovariantList[+A]

  // 2. INVARIANCE
  class InvariantList[A]

  // 3. CONTRAVARIANCE
  class Trainer[-A]

  // bounded types
  class Cage[A <: Animal](animal: A)

  class Car

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }


}
