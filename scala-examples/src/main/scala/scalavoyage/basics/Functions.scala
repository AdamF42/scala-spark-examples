package scalavoyage.basics

import scala.annotation.tailrec

object Functions extends App {

  def aDummyFunction(a: String, b: Int): String =
    a + " " + b

  // we can use a code block as function implementation since it is an Expression
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) // parameterless funs can be called also with name only

  // IN IMPERATIVE PROGRAMMING WE USE LOOPS. IN SCALA WE SHOULD USE RECURSION
  def aRepeatedFun(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFun(aString, n - 1)
  }

  println(aRepeatedFun("hello", 3))

  def aFunWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n - 1)
  }

  //Ex
  /*
  1. A greeting function (name,age) => "Hi, my name is $name and I am $age years old"
  2. A Factorial fun 1*2*3*...*n
  3. A Fibonacci fun
    f(1) = 1
    f(2) = 1
    f(n) = f(n-1) + f(n-2)
  4. Tests if a number is prime
   */

  def aGreetingFunction(name: String, age: Int): String = "Hi, my name is" + name + "and I am" + age + " years old"

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  def fibonacci(n: Int): Int =
    if (n <= 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  def isPrime(x: Int): Boolean = {
    @tailrec
    def isPrimeUntil(n: Int): Boolean = {
      if (n <= 1) true
      else x % n != 0 && isPrimeUntil(n - 1)
    }

    isPrimeUntil(x / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 69))
}
