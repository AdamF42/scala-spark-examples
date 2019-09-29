package it.unibo.algos.sorting

object SortingAlgorithmFactory {

  val QUICK_SORT = "quickSort"
  val INSERTION_SORT = "insertionSort"
  val MERGE_SORT = "mergeSort"
  val MERGE_SORT_WITH_PAIRS = "mergeSortWithPairs"

  def getAlgorithm(algorithm: String): SortingAlgorithm = algorithm match {
    case QUICK_SORT => new QuickSort
    case INSERTION_SORT => new InsertionSort
    case MERGE_SORT => new MergeSort
    case MERGE_SORT_WITH_PAIRS => new MergeSortWithPairs
  }
}
