package game

/**
  * Created by salim on 3/9/2017.
  */
object GameRules {

  val dice: Dice = Dice(2, 6)

  def gameRound(gs: GameState) = {

    gs.players.foreach((player: Player) => gameTurn(gs, player))


  }

  def gameTurn(gs: GameState, player: Player) = {
    val diceThrow = dice.throwDice
    gs.advancePlayer(player, diceThrow.score)
  }


}
