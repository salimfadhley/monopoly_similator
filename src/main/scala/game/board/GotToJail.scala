package game.board

import game.{GameState, Player}

/**
  * Created by salim on 3/8/2017.
  */
case class GotToJail() extends PricelessLocation {
  override val name: String = "Go To Jail"

  override def landOnAction(gs: GameState, p: Player): Unit = {
    gs.goToJail(p)
  }

}
