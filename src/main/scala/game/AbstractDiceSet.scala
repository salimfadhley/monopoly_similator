package game

import scala.util.Random

/**
  * Created by salim on 3/10/2017.
  */
trait AbstractDiceSet {
  val r = new Random()
  val throws: Iterator[DiceResult] = Iterator.continually(diceThrow)

  def diceThrow: DiceResult
}
