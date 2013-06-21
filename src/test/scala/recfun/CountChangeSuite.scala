package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  
  import Main.countChange
  
  test("change of 0 has only 1 chance!") {
    assert(countChange(0, List(1,2,3)) == 1)
  }
  
  test("change of something without coins has 0 combinations!") {
    assert(countChange(3, List()) == 0)
  }
  
  
//  test("countChange: example given in instructions") {
//    assert(countChange(4,List(1,2)) === 3)
//  }
  
//  test("unordered greater than sum") {
//    assert(countChange(4,List(5,2,1)) === 3)
//  }
  

//  test("countChange: sorted CHF") {
//    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
//  }
//
//  test("countChange: no pennies") {
//    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
//  }
//
//  test("countChange: unsorted CHF") {
//    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
//  }
  
}
