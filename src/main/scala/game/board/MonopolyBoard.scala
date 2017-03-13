package game.board

/**
  * Created by salim on 3/8/2017.
  */
object MonopolyBoard {

  implicit def intToOption(i:Int):Option[Int] = Some(i)

  lazy val nameToLocationNumber: Map[String, Int] = locations.zipWithIndex.map((t: (Location, Int)) => (t._1.name, t._2)).toMap
  val locations:List[Location] = List(
    Go(),
    Property("Old Kent Road", 60),
    CommunityChest(0),
    Property("Whitechapel Road", 60),
    IncomeTax(),
    Railway("Kings Cross", 200),
    Property("The Angel Islington", 60),
    Chance(0),
    Property("Euston Road", 100),
    Property("Pentonville Road", 120),
    Jail(),
    Property("Pall Mall", 140),
    Utility("Electric Company", 150),
    Property("Whitehall", 140),
    Property("Northumberland Avenue", 160),
    Railway("Marlybone", 200),
    Property("Bow Street", 180),
    CommunityChest(1),
    Property("Marlborough Street", 180),
    Property("Vine Street", 200),
    FreeParking(),
    Property("Strand", 220),
    Chance(1),
    Property("Fleet Street", 220),
    Property("Trafalgar Square", 240),
    Railway("Fenchurch Street", 200),
    Property("Licester Square", 260),
    Property("Coventry Street", 260),
    Utility("Water Works", 150),
    Property("Picadilly", 280),
    GotToJail(),
    Property("Regent Street", 300),
    Property("Oxford Street", 300),
    CommunityChest(2),
    Property("Bond Street", 280),
    Railway("Liverpool Street", 200),
    Chance(2),
    Property("Park Lane", 350),
    SuperTax(),
    Property("Mayfair", 280)
  )

  def getLocation(l: String): Location = getLocation(getLocationNumber(l))

  def getLocationNumber(s: String): Int = nameToLocationNumber(s)

  def getLocation(i: Int): Location = locations(i % locationCount)

  def locationCount:Int = locations.length


}
