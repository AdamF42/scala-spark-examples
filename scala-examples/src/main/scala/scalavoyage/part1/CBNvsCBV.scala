package scalavoyage.part1

object CBNvsCBV extends App {

  // the $x value is evaluated before the function execution
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // the $x value is evaluated every time is referenced in fun body the function execution
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  def printFirst(x:Int, y: => Int): Unit = println(x)

 // printFirst( infinite(), 42) cause a stack overflow

  // It works cause the by name parameter delays the evaluation till is required
  printFirst(42, infinite())

}
