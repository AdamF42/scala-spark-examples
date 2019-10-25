package it.unibo


import it.unibo.algos.sorting.SortingAlgorithmFactory

import scala.util.Random

object App {

  def main(args: Array[String]) {
    val r: Random.type = scala.util.Random
    val randomList: List[Int] = (for (_ <- 1 to 10) yield r.nextInt(10)).toList
    val sortedList = it.unibo.utils.primitives.time(SortingAlgorithmFactory
      .getAlgorithm(SortingAlgorithmFactory.INSERTION_SORT))
      .sort(randomList)

    val sortedList2 = it.unibo.utils.primitives.time(SortingAlgorithmFactory
      .getAlgorithm(SortingAlgorithmFactory.MERGE_SORT_WITH_PAIRS)
      .sort(randomList))

  println(sortedList)
  println(sortedList2)

  }
}
