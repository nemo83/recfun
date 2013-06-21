package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("no braces at all should pass") {
    assert(balance("sentence without braces".toList))
  }

  test("just a pair to have fun") {
    assert(balance("sentence with (a couple) of braces".toList))
  }

  test("two opening should fail") {
    assert(balance("((".toList) === false)
  }

  test("open open close should fail as well") {
    assert(balance("(()".toList) == false)
  }

  test("first block is fine second is NOT!") {
    assert(balance("(())(()".toList) == false)
  }

  test("starting with closing is BAD!") {
    assert(balance(")(".toList) == false)
  }

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }
}
