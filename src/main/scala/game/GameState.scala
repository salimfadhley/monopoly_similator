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
  private var turn: Int = 0

  def nextTurn = {
    turn = getTurn + 1
    turn
  }

  def getTurn = turn

  def currentPlayer: Player = {
    getPlayer(getTurn % numberOfPlayers)
  }

  def getPlayer(i: Int): Player = players(i)

  def advancePlayer(player: Player, i: Int): Unit = {
    (1 to i).foreach((_) => stepPlayer(player))
    getPlayerLocation(player).landOnAction(this, player)
  }

  def getPlayerLocation(player: Player): Location = MonopolyBoard.getLocation(getPlayerLocationNumber(player))

  def stepPlayer(player: Player): Unit = {
    val newLocation: Int = getPlayerLocationNumber(player) + 1
    playerPostions += (player -> newLocation)
    MonopolyBoard.getLocation(newLocation).passOverAction(this, player)
  }

  def getPlayerLocationNumber(player: Player): Int = playerPostions.getOrElse(player, 0)

  def goToJail(player: Player): Unit = {
    jailStatus += (player -> true)
    movePlayer(player, MonopolyBoard.getLocationNumber("Jail"))
  }

  def movePlayer(p: Player, s: String): Unit = {
    movePlayer(p, MonopolyBoard.getLocationNumber(s))
  }

  def movePlayer(player: Player, locationNumber: Int): Unit = {
    playerPostions += (player -> locationNumber)
    MonopolyBoard.getLocation(locationNumber).moveAction(this, player)
  }

  def isPlayerInJail(player: Player): Boolean = jailStatus.getOrElse(player, false)

  def getOccupiedLocations: Iterator[Location] = playerPostions.valuesIterator.map(MonopolyBoard.getLocation)


}
