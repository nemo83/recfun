package recfun

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
  def balance(chars: List[Char]): Boolean = ???

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
