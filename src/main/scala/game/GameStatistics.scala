package game

import game.board.Location
import game.util.Counter

/**
  * Created by salim on 3/10/2017.
  */
class GameStatistics extends Stats {
  val locationCounter: Counter[Location] = Counter()

  override def logState(gs: GameState): Unit = {
    gs.getOccupiedLocations.foreach(locationCounter.count)
  }
}

