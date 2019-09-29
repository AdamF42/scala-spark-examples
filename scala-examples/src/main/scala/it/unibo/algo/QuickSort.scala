package it.unibo.algo

class QuickSort extends SortingAlgorithm{

  def sort(xs: List[Int]): List[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      List.concat(
        sort(xs filter (pivot > (_: Int))),
        xs filter (pivot == _),
        sort(xs filter (pivot < (_: Int))))
    }
  }
}