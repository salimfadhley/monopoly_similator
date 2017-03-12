package simulation

import game.GameState
import game.board.Location
import simulation.util.Counter

/**
  * Created by salim on 3/10/2017.
  */
class GameStatistics extends Stats {
  val locationCounter: Counter[Location] = Counter()
  var roundCount = 0

  override def logState(gs: GameState): Unit = {
    gs.getOccupiedLocations.foreach(locationCounter.count)
    roundCount += 1
  }
}

