package scalavoyage.basics

import scala.annotation.tailrec

object Recursion extends App {

  // This implementation cause StackOverflow
  def factorial(n: Int): Int =
    if (n <= 0) 1
    else {
      println("computing factorial of " + n + " need to compute " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed " + n)

      result
    }


  // Tail recursion = use recursion call as the LAST operation
  def smartFactorial(n: Int): BigInt = {
    @tailrec
    def helper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else helper(x - 1, x * accumulator)

    helper(n, 1)
  }

  /*
    smartFactorial(10) = helper(10, 1)
    = helper(9, 10 * 1)
    = helper(8, 9 * 10 * 1)
    = helper(7, 8 * 9 * 10 * 1)
    = . . .
    = helper(1 * 2 * 3 * . . . * 10 * 1)
    = 1 * 2 * 3 * . . . * 10 * 1
  */


  // Ex
  /*
  1. Concatenates a string using tail recursion
  2. Fibonacci tail recursive
   */

  def aRepeatedFunTailRecursive(aString: String, n: Int): String = {

    @tailrec
    def helper(x: Int, aString: String, accumulator: String): String =
      if (x <= 1) accumulator
      else helper(x - 1, aString, aString + accumulator)

    helper(n, aString, aString)
  }

  def fibonacci(n: Int): Int = {
    @tailrec
    def helper(i: Int, accumulator1: Int, accumulator2: Int): Int =
      if (i >= n) accumulator1
      else helper(1 + n, accumulator1 + accumulator2, accumulator2)

    if (n <= 2) 1
    else helper(2, 1, 1)
  }

}
