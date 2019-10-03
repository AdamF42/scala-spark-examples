package scalavoyage.basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFactorial(x: Int, accumulator: BigInt = 1): BigInt = // used default param
    if (x <= 1) accumulator
    else trFactorial(x - 1, x * accumulator)

  trFactorial(10)

  // Does not work since the compiler can't understand if the first param is default or not
  def savePicture(format: String = "jpg", width: Int = 800, height: Int = 600): Unit = println("saving picture")

  // SOLUTION
  // name the arguments
  savePicture(width = 1000)

}
