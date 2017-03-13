package game

import game.board.MonopolyBoard
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 3/9/2017.
  */
class GameStateSpec extends FlatSpec with Matchers {

  "GameState" can "be initialized with 2 or more players" in {
    val gs = GameState(4)
    gs.players.length should be(4)
  }

  it should "put all players at location 0" in {
    val gs = GameState(4)
    gs.players.foreach((p: Player) => assert(gs.getPlayerLocationNumber(p) == 0))
  }

  it should "put all players at a location called Go" in {
    val gs = GameState(2)
    assert(gs.getPlayerLocation(gs.getPlayer(0)).name == "Go")
  }

  it should "after advancing once the player should be at Old Kent Road" in {
    val gs = GameState(2)
    val p = gs.getPlayer(0)
    gs.advancePlayer(p, 1)
    assert(gs.getPlayerLocation(p).name == "Old Kent Road")
  }

  it should "after advancing exactly one round the board you should be at Go" in {
    val gs = GameState(2)
    val p = gs.getPlayer(0)
    gs.advancePlayer(p, MonopolyBoard.locationCount)
    assert(gs.getPlayerLocation(p).name == "Go")
  }

  it should "after advancing exactly one round the board and moving 2 more squares you should be at Community Chest" in {
    val gs = GameState(2)
    val p = gs.getPlayer(0)
    gs.advancePlayer(p, MonopolyBoard.locationCount + 2)
    assert(gs.getPlayerLocation(p).name == "Community Chest 0")
  }

  it should "be able to move players to jail" in {
    val gs = GameState(2)
    val p = gs.getPlayer(1)
    gs.goToJail(p)
    assert(gs.getPlayerLocation(p).name == "Jail")
  }

  it should "know that players start out not in jail" in {
    val gs = GameState(2)
    val p = gs.players.head
    assert(!gs.isPlayerInJail(p))
  }

  it should "start with a turn counter set to zero" in {
    val gs = GameState(2)
    assert(gs.getTurn == 0)
    assert(gs.currentPlayer == gs.players.head)
  }

  it should "increment the turn counter" in {
    val gs = GameState(2)
    assert(gs.nextTurn == 1)
    assert(gs.currentPlayer == gs.players.tail.head)
    assert(gs.getRound == 0)
  }

  it should "go back to the first player after everybody has had a turn" in {
    val gs = GameState(3)
    assert(gs.nextTurn == 1)
    assert(gs.nextTurn == 2)
    assert(gs.getRound == 0)
    assert(gs.nextTurn == 3)
    assert(gs.currentPlayer == gs.players.head)
    assert(gs.getRound == 1)
  }

  it should "initially the last dice throw is none" in {
    val gs = GameState(2)
    assert(gs.lastDiceThrow.isEmpty)
  }

  it should "be able to roll the dice" in {
    val gs = GameState(2)
    val dr: DiceResult = gs.throwDice
    assert(gs.lastDiceThrow.get == dr)
  }

  it should "reset the last roll when the next " in {
    val gs = GameState(2)
    gs.throwDice
    gs.nextTurn
    assert(gs.lastDiceThrow.isEmpty)
  }

}
