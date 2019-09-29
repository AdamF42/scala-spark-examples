package it.unibo.algos.square

class DummySquare extends Square {

  override def squareList(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case y :: ys => y * y :: squareList(ys)
  }
}
