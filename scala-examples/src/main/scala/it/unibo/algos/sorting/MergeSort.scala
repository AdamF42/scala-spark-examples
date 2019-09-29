package it.unibo.algos.sorting

class MergeSort extends SortingAlgorithm {

  override def sort(listToSort: List[Int]): List[Int] = {
    val n = listToSort.length / 2
    if (n == 0) listToSort else {
      val (fst, snd) = listToSort splitAt n
      merge(sort(fst), sort(snd))
    }
  }

  def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
      case Nil => ys
      case x :: xs1 =>
        ys match {
          case Nil => xs
          case y :: ys1 =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
    }
}
