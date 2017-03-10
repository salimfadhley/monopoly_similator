package game

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 3/9/2017.
  */
class GameRulesSpec extends FlatSpec with Matchers {

  "GameRules" should "move every player after the first round" in {
    val gs = GameState(2)
    val dice = Dice()
    GameRules(gs, dice).gameRound()
    gs.players.foreach((player: Player) => {
      assert(gs.getPlayerLocationNumber(player) > 0)
    })
  }

  it should "put players in jail if they keep rolling doubles" in {
    val gs = GameState(2)
    val dice = Dice(2, 1)
    val p = gs.players.head
    val gr = GameRules(gs, dice)
    gr.gameTurn(p)
    assert(gs.getPlayerLocation(p).name == "Jail")
    assert(gs.isPlayerInJail(p), true)
  }

  it should "not get you out of jail unless you throw a double" in {

    case class FunnyDice() extends AbstractDiceSet {
      override def diceThrow: DiceResult = DiceResult(3, matching = false)
    }

    val gs = GameState(2)
    val p = gs.players.head
    gs.goToJail(p)
    assert(gs.isPlayerInJail(p), true)
    assert(gs.getPlayerLocation(p).name == "Jail")
    val gr = GameRules(gs, FunnyDice())
    gr.gameTurn(p)
    assert(gs.getPlayerLocation(p).name == "Jail")
    assert(gs.isPlayerInJail(p), true)


  }

}
