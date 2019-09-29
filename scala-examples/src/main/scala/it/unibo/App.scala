package it.unibo


import it.unibo.algo.SortingAlgorithmFactory

import scala.util.Random

object App {

  def main(args: Array[String]) {
    val r: Random.type = scala.util.Random
    val randomList: List[Int] = (for (_ <- 1 to 10) yield r.nextInt(10)).toList
    val sortedList: List[Int] = SortingAlgorithmFactory
      .getAlgorithm(SortingAlgorithmFactory.QUICK_SORT)
      .sort(randomList)

    sortedList.foreach(println)
  }

}
