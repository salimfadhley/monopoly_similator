package simulation

import game.board.{Location, MonopolyBoard}
import game.{Dice, GameRulesOld, GameState}

/**
  * Created by salim on 3/10/2017.
  */
object Main extends App {
  val numberOfRoundsPerGame = 30
  val numberOfSimulations = 1000
  val numberOfPlayers = 1

  val stats = new GameStatistics()
  val dice = Dice() // Regular Dice

  0.until(numberOfSimulations).foreach((simulationNumber: Int) => {
    println(s"Simulation $simulationNumber")
    val gameState: GameState = GameState(numberOfPlayers)
    val game = GameRulesOld(gameState, dice, Some(stats))
    game.play(numberOfRoundsPerGame)
  })

  MonopolyBoard.locations.foreach((l: Location) => {

    val score = stats.locationCounter(l).toFloat / (stats.roundCount * numberOfPlayers)
    val locationName = l.name
    println(s"$locationName,$score")
  }
  )

}
