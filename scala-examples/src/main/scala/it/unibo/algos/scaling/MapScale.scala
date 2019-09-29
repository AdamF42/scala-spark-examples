package it.unibo.algos.scaling

class MapScale extends Scale {

  override def scaleList(xs: List[Double], factor: Double): List[Double] = xs map (x => x * factor)
}
