package game

import simulation.Stats

/**
  * Created by salim on 3/9/2017.
  */
case class GameRules(gs: GameState, dice: AbstractDiceSet = Dice(), stats: Option[Stats] = None) {

  def play(rounds:Int):Unit = {
    for (elem <- 0.until(rounds)) {
      gameRound()
    }
  }

  def gameRound(): Unit = {
    // Each player takes their turn
    gs.players.foreach((player: Player) => gameTurn(player))
    stats match {
      case Some(s) => s.logState(gs)
      case None =>
    }
  }

  def gameTurn(implicit player: Player): Unit = {
    val diceThrow0 = dice.diceThrow

    if (playerCanMove(player, diceThrow0.matching)) {
      gameMove(player, diceThrow0.score)

      if (diceThrow0.matching) {
        val diceThrow1 = dice.diceThrow
        gameMove(player, diceThrow1.score)

        if (diceThrow1.matching) {
          val diceThrow2 = dice.diceThrow

          if (diceThrow2.matching) {
            gs.goToJail(player)
          } else {
            gameMove(player, diceThrow2.score)
          }
        }
      }
    }
  }

  def gameMove(player: Player, spaces: Int): Unit = {
    gs.advancePlayer(player, spaces)
  }

  def playerCanMove(implicit player: Player, matching: Boolean): Boolean = {
    (gs.isPlayerInJail(player), matching) match {
      case (true, true) => true
      case (false, _) => true
      case _ => false
    }
  }
}
