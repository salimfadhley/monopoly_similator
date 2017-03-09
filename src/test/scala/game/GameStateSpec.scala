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
    assert(gs.getPlayerLocation(p).name == "Community Chest")
  }

}
