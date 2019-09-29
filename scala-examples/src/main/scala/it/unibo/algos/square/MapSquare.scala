package it.unibo.algos.square

class MapSquare extends Square {
  override def squareList(list: List[Int]): List[Int] = list map (x => x * x)
}
