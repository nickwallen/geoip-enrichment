
import com.sanoma.cda.geoip.MaxMindIpGeo

object Sniff extends App {
  
  val dbPath = "GeoLite2-City.mmdb"
  val db = getClass.getClassLoader.getResourceAsStream(dbPath)
  val geoIp = new MaxMindIpGeo(db, 1000, false, Set())
  println(geoIp.getLocation("123.123.123.123"))
}
