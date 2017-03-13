package game.board

/**
  * Created by salim on 3/8/2017.
  */
case class CommunityChest(number: Int) extends PricelessLocation {
  override val name: String = s"Community Chest $number"
}
