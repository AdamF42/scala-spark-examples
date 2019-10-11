package it.unibo.exercises

// voglio aggiungere un nuovo insieme di tipi che è l'intset
// l'insime o è vuoto o è un insieme con altri elementi (def ricorsiva)

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(x: IntSet): IntSet

  def isEmpty: Boolean

  def str: String
}

object Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  def contains(x: Int): Boolean = false

  def union(x: IntSet): IntSet = x

  def isEmpty = true

  override def toString: String = "{}"

  def str = ""
}

// left e right ricorda un albero
// albero ordinato = albero binario di ricerca
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(x: IntSet): IntSet = (left union x) union right incl elem

  def isEmpty = false

  override def toString: String = s"{$str}"

  def str: String =
    if (left.isEmpty) "" + elem + (
      if (right.isEmpty) ""
      else "," + right.str
      )
    else left.str + "," + elem + (
      if (right.isEmpty) ""
      else "," + right.str
      )
}

object IntSet extends App {

  val set1: IntSet = Empty incl 3 incl 2 incl 5
  val set2: IntSet = Empty incl 1 incl 3 incl 8

  println(set1)
  println(set2)
  //
  //  println(set1 contains 2)
  //  println(set2 contains 7)

}
