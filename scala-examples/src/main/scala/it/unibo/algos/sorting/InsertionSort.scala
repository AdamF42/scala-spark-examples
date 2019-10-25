package it.unibo.algos.sorting

class InsertionSort extends SortingAlgorithm {

  override def sort(listToSort: List[Int]): List[Int] = listToSort match {
    case List() => List()
    case f :: r => insert(f, sort(r))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x)
    case f :: r =>
      if (x < f) x :: xs
      else f :: insert(x, r)
  }
}