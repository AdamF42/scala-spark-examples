package it.unibo.algo

object SortingAlgorithmFactory {

  val QUICK_SORT="quickSort"

  def getAlgorithm(s: String):SortingAlgorithm = {
    if (s == QUICK_SORT) new QuickSort
    else null
  }
}
