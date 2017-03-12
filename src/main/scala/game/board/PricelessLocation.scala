package game.board

/**
  * Created by salim on 3/11/2017.
  */
trait PricelessLocation extends Location {
  override val price: Option[Int] = None
}
