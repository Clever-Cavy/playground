package playground

import scala.io.StdIn

trait SolutionUtils {
  protected def readNumbers: Array[Int] = {
    StdIn.readLine().split(" ").map(_.toInt)
  }

  protected def printCase(testCase: Int, sum: Int): Unit = {
    println(s"Case #$testCase: $sum")
  }
}
