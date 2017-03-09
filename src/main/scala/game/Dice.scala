package game

import scala.util.Random

/**
  * Created by salim on 3/9/2017.
  */
case class Dice(number: Int = 2, sides: Int = 6) {
  val r = new Random()

  def throwDice: DiceResult = {
    val throws = (0 until number).map((_) => Random.nextInt(sides) + 1).toList
    DiceResult(throws.sum, throws.toSet.size == 1)
  }

}
