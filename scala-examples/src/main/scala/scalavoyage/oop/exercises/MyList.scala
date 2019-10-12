package scalavoyage.oop.exercises

abstract class MyList[+A] {

  // list of integers
  /*
    - head
    - tail
    - isEmpty
    - add(int) => new MyList
    - toString()
   */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = s"[$printElements]"
}

object Empty extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing] (element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""
}


class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >:A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}


object LIstTest extends App {
  val list = new Cons(1, new Cons(2, Empty))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.toString)
}