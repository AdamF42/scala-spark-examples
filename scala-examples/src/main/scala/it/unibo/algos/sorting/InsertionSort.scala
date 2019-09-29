package it.unibo.algos.sorting

class InsertionSort extends SortingAlgorithm {

  override def sort(listToSort: List[Int]): List[Int] = listToSort match {
    case List() => List()
    case y :: ys => insert(y, sort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
  }

}