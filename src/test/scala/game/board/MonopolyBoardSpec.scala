package game.board

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 3/9/2017.
  */
class MonopolyBoardSpec extends FlatSpec with Matchers {

  "MonopolyBoard" can "find locations by name" in {
    assert(MonopolyBoard.getLocationNumber("Mayfair") == 39)
  }

  it can "find Jail by name" in {
    assert(MonopolyBoard.getLocation(MonopolyBoard.getLocationNumber("Jail")).name == "Jail")
  }

}
