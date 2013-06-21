package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c > r)
      throw new IllegalArgumentException("incorrect column index")
    def calculateRow(prevRow: List[Int]): List[Int] = {
      @tailrec
      def calculateRowLoop(prevReversedRow: List[Int], partialResult: List[Int]): List[Int] = {
        if (prevReversedRow.length == 1) List(1) ::: partialResult
        else calculateRowLoop(prevReversedRow.tail, List(prevReversedRow.head + prevReversedRow(1)) ::: partialResult)
      }
      calculateRowLoop(prevRow.reverse, List(1))
    }
    def tree(rowIndex: Int, prevRow: List[Int]): Int = {
      if (rowIndex == r) prevRow(c)
      else tree(rowIndex + 1, calculateRow(prevRow))
    }
    tree(0, List(1))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val filteredChars = chars.filter(x => x == '(' || x == ')')
    @tailrec
    def balanceLoop(openOnes: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty)
        if (openOnes == 0) true
        else false
      else if (chars.head == '(') balanceLoop(openOnes + 1, chars.tail)
      else if (openOnes == 0) false
      else balanceLoop(openOnes - 1, chars.tail)
    }
    balanceLoop(0, filteredChars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    val filteredSortedReversedCoins = coins.filter(x => x <= money).sorted.reverse

    def countChangeLoop(numCorrectCombination: Int, coins: List[Int]): Int = {
      0
    }

    countChangeLoop(0, filteredSortedReversedCoins)

  }
}
