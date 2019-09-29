package it.unibo.algos.sorting

class MergeSortWithPairs extends SortingAlgorithm {

  override def sort(listToSort: List[Int]): List[Int] = {
    val n = listToSort.length / 2
    if (n == 0) listToSort else {
      val (fst, snd) = listToSort splitAt n
      merge(sort(fst), sort(snd))
    }
  }

  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (Nil, _) => ys
    case (_, Nil) => xs
    case (x :: xs1, y :: ys1) =>
      if (x < y) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
  }
}
