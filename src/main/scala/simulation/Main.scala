package simulation

import game.board.{Location, MonopolyBoard}
import game.{Dice, GameRules, GameState}

/**
  * Created by salim on 3/10/2017.
  */
object Main extends App {
  val numberOfRoundsPerGame = 30
  val numberOfSimulations = 1000
  val numberOfPlayers = 4

  val stats = new GameStatistics()
  val dice = Dice() // Regular Dice

  0.until(numberOfSimulations).foreach((simulationNumber: Int) =>{
        println (s"Simulation $simulationNumber")
        val gameState: GameState = GameState (numberOfPlayers)
        val game = GameRules (gameState, dice, Some (stats) )
        game.play (numberOfRoundsPerGame)
  })

  stats.locationCounter.state.foreach((x: (Location, Int)) =>{
    val score = x._2.toFloat / stats.roundCount
    val locationName = x._1.name
    val price = x._1.price
    println(s"${locationName},${score},${price}")
  })


}
