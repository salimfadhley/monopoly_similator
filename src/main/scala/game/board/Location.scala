package game.board

import game.{DiceResult, GameState, Player}

/**
  * Created by salim on 3/8/2017.
  */
trait Location {

  val name:String

  val price:Option[Int]

  // Called if you pass over this square
  def passOverAction(gs: GameState, p: Player): Unit = {}

  // Called if you are moved to this square
  def moveAction(gs: GameState, p: Player): Unit = {}

  // Called if you land on this square
  def landOnAction(gs: GameState, p: Player): Unit = {}



}
