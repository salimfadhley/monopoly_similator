package game

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 3/9/2017.
  */
class GameRulesSpec extends FlatSpec with Matchers {

  "GameRules" should "move every player after the first round" in {
    val gs = GameState(2)
    GameRules.gameRound(gs)

    gs.players.foreach((player: Player) => {
      assert(gs.getPlayerLocationNumber(player) > 0)
    })

  }

}
