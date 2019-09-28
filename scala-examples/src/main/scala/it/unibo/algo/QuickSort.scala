package it.unibo.algo

class QuickSort extends SortingAlgorithm{

  def sort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        sort(xs filter (pivot > (_: Int))),
        xs filter (pivot == _),
        sort(xs filter (pivot < (_: Int))))
    }
  }
}