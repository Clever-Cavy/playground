package playground.google.round2020a

import playground.SolutionUtils

/**
 * take some plates from head of each stack
 * to get exactly 'plates' number of plates and
 * to make max sum of numbers
 *
 */
object Plates extends SolutionUtils {
  val MaxBeauty = 100
  val MaxStack = 30
  val MaxStacks = 50

  private def subTotals(stack: Seq[Int]): Map[Int, Int] = {
    stack
      .scan(0)(_ + _)
      .view
      .zipWithIndex
      .map(_.swap)
      .toMap
  }

  def solve(stacks: Seq[Seq[Int]], depth: Int, plates: Int): Int = {
    val solutions = stacks.view.map(subTotals).reduce { (previousStacks, currentStack) =>
      val availablePlates = Math.min(plates, previousStacks.size + depth)
      (1 to availablePlates).view.map { plates =>
        val availableToPickFromStack = Math.min(plates, depth)
        val max = (0 to availableToPickFromStack).view.map { currentCount =>
          val restCount = plates - currentCount
          currentStack(currentCount) + previousStacks.getOrElse(restCount, 0)
        }.max
        plates -> max
      }.toMap
    }
    solutions(plates)
  }

  def executeTestCases() = {
    for {
      test <- 1 to readNumbers.head
      Array(n, k, p) = readNumbers
      stacks = (1 to n).map(_ => readNumbers.toSeq)
    } {
      printCase(test, solve(stacks, k, p))
    }
  }
}
