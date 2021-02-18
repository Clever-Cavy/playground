package playground.google.round2020a

import playground.SolutionUtils

/**
 * There are N houses for sale.
 * The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.
 * What is the maximum number of houses you can buy?
 */
object Allocation extends SolutionUtils {
  final val MaxCost = 1001

  def solve(budget: Int, houses: Seq[Int]): Int = {
    val costDistribution = Array.fill(MaxCost)(0)
    houses.foreach(houseCost => costDistribution(houseCost) += 1)
    var totalSum = 0
    var totalCount = 0
    for {
      (available, cost) <- costDistribution.zipWithIndex.drop(1)
    } {
      val maxToBuy = (budget - totalSum) / cost
      val toBuy = Math.min(maxToBuy, available)
      val paycheck = toBuy * cost
      if (totalSum + paycheck > budget) {
        totalCount
      } else {
        totalSum += paycheck
        totalCount += toBuy
      }
    }
    totalCount
  }

  def executeTestCase() = {
    for {
      testCase <- 1 to readNumbers.head
      Array(n, budget) = readNumbers
      costs = readNumbers
    } {
      val sum = solve(budget, costs)
      printCase(testCase, sum)
    }
  }
}
