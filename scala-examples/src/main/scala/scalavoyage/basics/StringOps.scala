package scalavoyage.basics

object StringOps extends App {
  val str: String = "Hello, I'm the Big Boss"
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)

  // Scala-specific: String Interpolators.

  // S-interpolator
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old"

  // F-interpolator
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per min" // printf like format means 2 char minimum with 2 decimal precision

  // raw-interpolator: Ignore escaped values inside string
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped") // the back slash will be escaped
}
