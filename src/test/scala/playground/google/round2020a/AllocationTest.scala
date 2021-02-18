package playground.google.round2020a

class AllocationTest extends SolutionTest {
  it should "work for trivial cases" in {
    Allocation.solve(10, Seq(1000)) shouldBe 0
    Allocation.solve(1000, Seq(1)) shouldBe 1
    Allocation.solve(0, Seq()) shouldBe 0
    Allocation.solve(100, Seq(1, 40, 20, 150, 401, 2)) shouldBe 4
  }

  it should "work for heavy load" in {
    fitsExecutionTime(10) {
      Allocation.solve(100, (1 to 1000).flatMap(_ => Seq(10, 20, 30, 40, 50))) shouldBe 10
    }
  }
}
