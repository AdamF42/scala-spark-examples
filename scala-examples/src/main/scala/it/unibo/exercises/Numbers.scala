package it.unibo.exercises

object Numbers extends App {

}

class Rational(x: Int, y: Int) {
  val numer: Int = x;
  val denom: Int = y

  override def toString: String = numer + "/" + denom
}

class Segment(x: Int, y: Int) {
  val x_axis: Int = x;
  val y_axis: Int = y

  override def toString: String = "<" + x_axis + "," + y_axis + ">"
}

trait TotOrder[T] {

  def compare(r: T): Double // positive if this is greater

  def >(r: T): Boolean = (this compare r) > 0

  def <(r: T): Boolean = (this compare r) < 0

  def >=(r: T): Boolean = !(this < r)

  def <=(r: T): Boolean = !(this > r)

}


class OrdRat(x: Int, y: Int) extends Rational(x, y) with TotOrder[OrdRat] {
  def compare(r: OrdRat): Double = (numer * r.denom - r.numer * denom)
}

class OrdSeg(x: Int, y: Int) extends Segment(x, y) with TotOrder[OrdSeg] {
  def compare(r: OrdSeg): Double =
    Math.abs(x_axis - y_axis) - Math.abs(r.x_axis - r.y_axis)
}



