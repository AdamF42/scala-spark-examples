package scalavoyage.basics

object Expressions extends App {
  // Instruction: something you tell the computer to do (DO)
  // Expression: something that have a value or end with a type

  // IF expression

  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)
  val aValue: Unit = (aVariable = 3) // Unit === void
  while (i < 10) {
    println(i)
    i += 1
  }
  // Expressions with side-effects returns a Unit
  val aWhile: Unit = while (i < 10) {
    println(i)
    i += 1
  }
  // CODE BLOCKS: the value of the block is the value of it's last expression
  val aCodeBlock: String = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  println(aValue)
  // 1. What is the difference between "hello word" vs println("hello world")?
  // ==> value of type String vs expression with side-effects of type Unit
  // 2. What's the value of
  val someVal: Boolean = {
    2 < 3
  } // true
  println(aWhile)
  val someOtherVal: Int = {
    if (someVal) 239 else 986
    42
  } // 42
  // NEVER WRITE THIS!!! It's just a test
  var i = 0
  // EVERYTHING IN SCALA IS AN EXPRESSION
  var aVariable = 4


}
