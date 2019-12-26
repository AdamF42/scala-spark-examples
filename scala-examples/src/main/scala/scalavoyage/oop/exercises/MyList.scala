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

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[A]
}

object Empty extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[Nothing] = list
}


class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[A] = new Cons(h, t ++ list)

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

}

/*
  1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
  2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
  3. MyList
    - map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(tranformer from A to Mylist[B] => MyList[B]


    Example

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformer[String, Int]

    [1,2,3].map(n*2) = [2,4,6]
    [1,2,3,4].filter(n % 2) = [2, 4]
    [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
 */


trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object LIstTest extends App {
  val list = new Cons(1, new Cons(2, Empty))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.toString)
}