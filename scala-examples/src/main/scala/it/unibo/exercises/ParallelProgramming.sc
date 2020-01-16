import it.unibo.utils.primitives._

def sumSegment(a: Array[Double], p: Double, s: Int, t: Int):
Double = {
  var i = s; var sum: Double = 0
  while (i < t) {
    sum = sum + Math.pow(a(i), p)
    i = i + 1
  }
  sum
}


val threshold = 20000

def pNormTwoParts(a: Array[Double], p: Double): Double = {
  val m = a.length / 2
  val (sum1, sum2) = parallel(sumSegment(a, a.length, 0, m),
    sumSegment(a, p, m, a.length))
  Math.pow((sum1 + sum2), 1 / p)
}

def segmentRec(a: Array[Double], p: Double, s: Int, t: Int):
Double = {
  if (t - s < threshold)
    sumSegment(a, p, s, t) // small segment done sequentially
  else {
    val m = s + (t - s) / 2
    val (sum1, sum2) = parallel(
      segmentRec(a, p, s, m),
      segmentRec(a, p, m, t))
    sum1 + sum2
  }
}
def pNormRec(a: Array[Double]): Double =
  Math.pow (segmentRec(a, a.length, 0, a.length), 1 / a.length)


// estimation of pi
import scala.util.Random
// Sequential implementation
def mcCount(iter: Int): Int = {
  val randomX = new Random
  val randomY = new Random
  var hits = 0
  for (i <- 0 until iter) {
    val x = randomX.nextDouble // in [0,1]
    val y = randomY.nextDouble // in [0,1]
    if (x * x + y * y < 1) hits = hits + 1
  }
  hits
}

def monteCarloPiSeq(iter: Int): Double =
  4.0 * mcCount(iter) / iter

// Parallel implementation
def monteCarloPiPar(iter: Int): Double = {
  val (pi1, pi2, pi3, pi4) = parallel(
    mcCount(iter / 4),
    mcCount(iter / 4),
    mcCount(iter / 4),
    mcCount(iter / 4)
  )
  4.0 * (pi1 + pi2 + pi3 + pi4) / iter
}

// Is it possible to win against scala sorting algorithm
// with a parallel sorting?
def parMergeSort(xs: Array[Int], maxDepth: Int): Unit = {
  val ys = new Array[Int](xs.length) // used to merge

  def sort(from: Int, until: Int, depth: Int): Unit = {
    if (depth == maxDepth) {
      quickS(xs, from, until)
    } else {
      val mid = (from + until) / 2
      parallel(sort(mid, until, depth + 1),
        sort(from, mid, depth + 1))
      val flip = (maxDepth - depth) % 2 == 0
      val src = if (flip) ys else xs
      val dst = if (flip) xs else ys
      merge(src, dst, from, mid, until)
    }
  }
  ...
}

