package game

import game.board.{Location, MonopolyBoard}

import scala.collection.mutable

/**
  * Created by salim on 3/9/2017.
  */
case class GameState(numberOfPlayers: Int) {
  lazy val players: List[Player] = {
    (0 until numberOfPlayers).map(Player).toList
  }
  private val jailStatus: mutable.Map[Player, Boolean] = mutable.HashMap[Player, Boolean]()
  private val playerPostions: mutable.Map[Player, Int] = mutable.HashMap[Player, Int]()

  def getPlayer(i: Int): Player = players(i)

  def advancePlayer(player: Player, i: Int): Unit = {
    (1 to i).foreach((_) => stepPlayer(player))
    getPlayerLocation(player).landOnAction(this, player)
  }

  def getPlayerLocation(player: Player): Location = MonopolyBoard.getLocation(getPlayerLocationNumber(player))

  def getPlayerLocationNumber(player: Player): Int = playerPostions.getOrElse(player, 0)

  def stepPlayer(player: Player): Unit = {
    val newLocation: Int = getPlayerLocationNumber(player) + 1
    playerPostions += (player -> newLocation)
    MonopolyBoard.getLocation(newLocation).passOverAction(this, player)
  }

  def goToJail(player: Player): Unit = {
    jailStatus += (player -> true)
    movePlayer(player, MonopolyBoard.getLocationNumber("Jail"))
  }

  def movePlayer(player: Player, locationNumber: Int): Unit = {
    playerPostions += (player -> locationNumber)
    MonopolyBoard.getLocation(locationNumber).moveAction(this, player)
  }

  def isPlayerInJail(player: Player): Boolean = {
    jailStatus.getOrElse(player, false)
  }

}
