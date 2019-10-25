package it.unibo.exercises

class SortingAlgo {

  def merge(fst: List[Int], snd: List[Int]): List[Int] = (fst, snd) match {
    case (Nil, _) => snd
    case (_, Nil) => fst
    case (l1::list1, l2::list2) =>
      if (l1 < l2) l1::merge(list1, snd)
      else l2::merge(fst, list2)
  }

  def msort(l: List[Int]): List[Int] = {
    val n = l.length / 2
    if (n == 0) l
    else {
      val (fst, snd) = l splitAt n
      merge(msort(fst), msort(snd))
    }
  }

}

object Pairs extends App {

  val pair = ("test", 42)

  pair._1
  pair._2
  val (label, value) = pair

  val (fstHalt, sndHalf) = List(1, 2, 3, 4, 5) splitAt 3


}


