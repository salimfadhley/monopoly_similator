package game

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 3/9/2017.
  */
class DiceSpec extends FlatSpec with Matchers {

  "dice" can "be thrown" in {
    val r: DiceResult = Dice().diceThrow
  }

  it can "be used as a stream" in {
    val r: DiceResult = Dice().throws.next()
  }

}
