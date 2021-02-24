package playground.google.round2020a

import scala.util.Random

class PlatesTest extends SolutionTest {
  it should "work for trivial cases" in {
    Plates.solve(Seq(
      Seq(10, 10, 100, 30),
      Seq(80, 50, 10, 50),
    ), depth = 4, plates = 5) shouldBe 250

    Plates.solve(Seq(
      Seq(15, 10, 100, 30),
      Seq(10, 50, 100, 50),
      Seq(80, 50, 10, 200),
    ), depth = 4, plates = 5) shouldBe 355
  }

  it should "give same results in a reasonable time" in {
    val random = new Random(10)
    fitsExecutionTime(10) {
      val stacks = (1 to Plates.MaxStacks).map { _ =>
        (1 to Plates.MaxStack).map { _ =>
          random.nextInt(Plates.MaxBeauty)
        }
      }
      Plates.solve(stacks, Plates.MaxStack, 1000) shouldBe 54596
    }
  }
}
