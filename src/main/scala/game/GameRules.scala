package game

/**
  * Created by salim on 3/9/2017.
  */
object GameRules {

  val dice: Dice = Dice()

  def gameRound(gs: GameState) = {

    gs.players.foreach((player: Player) => gameTurn(gs, player))


  }

  def gameTurn(gs: GameState, player: Player) = {
    val diceThrow = dice.diceThrow
    gs.advancePlayer(player, diceThrow.score)
  }


}
