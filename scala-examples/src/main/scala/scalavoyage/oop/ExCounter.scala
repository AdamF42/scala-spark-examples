package scalavoyage.oop

object ExCounter extends App {
  val counter = new Counter(0)
  counter.inc.print()
}

class Counter(val count: Int) {

  def inc = new Counter(count + 1)

  def dec = new Counter(count - 1)

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print(): Unit = println(count)
}