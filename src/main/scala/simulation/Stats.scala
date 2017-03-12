package simulation

import game.GameState

/**
  * Created by salim on 3/10/2017.
  */
trait Stats {
  def logState(gs: GameState): Unit
}
