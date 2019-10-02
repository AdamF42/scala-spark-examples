package scalavoyage.part1

object Expressions extends App {
  // Instruction: something you tell the computer to do (DO)
  // Expression: something that have a value or end with a type

  // IF expression

  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)

  // NEVER WRITE THIS!!! It's just a test
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING IN SCALA IS AN EXPRESSION
  var aVariable = 4
  val aValue: Unit = (aVariable = 3) // Unit === void
  println(aValue)

  // Expressions with side-effects returns a Unit
  val aWhile: Unit = while (i < 10) {
    println(i)
    i += 1
  }
  println(aWhile)

  // CODE BLOCKS: the value of the block is the value of it's last expression
  val aCodeBlock: String = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // 1. What is the difference between "hello word" vs println("hello world")?
  // ==> value of type String vs expression with side-effects of type Unit
  // 2. What's the value of
  val someVal: Boolean = {
    2 < 3
  } // true

  val someOtherVal: Int = {
    if (someVal) 239 else 986
    42
  } // 42


}
