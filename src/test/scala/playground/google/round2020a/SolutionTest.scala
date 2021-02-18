package playground.google.round2020a

import org.scalatest.Assertion
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolutionTest extends AnyFlatSpec with Matchers{

  protected def fitsExecutionTime(seconds: Int)(f: => Any): Assertion = {
    val before = System.currentTimeMillis()
    f
    val after = System.currentTimeMillis()
    (after - before) should not be > (seconds * 1000)
  }
}
