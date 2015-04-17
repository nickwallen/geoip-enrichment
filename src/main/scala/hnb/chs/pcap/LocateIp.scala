package hnb.chs.pcap

import backtype.storm.topology.base.BaseBasicBolt
import com.sanoma.cda.geoip.MaxMindIpGeo
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.BasicOutputCollector
import backtype.storm.tuple.Tuple
import backtype.storm.task.TopologyContext
import java.util.Map

class LocateIp extends BaseBasicBolt {
  val ipdb = getClass.getClassLoader.getResourceAsStream("GeoLite2-City.mmdb")
  val locator = new MaxMindIpGeo(ipdb, 1000, false, Set())

  override def declareOutputFields(d: OutputFieldsDeclarer) = {
  }

  override def prepare(config: Map[_, _], context: TopologyContext) = {
  }

  override def execute(tuple: Tuple, collector: BasicOutputCollector) = {
  }

  def getLocation(ipAddress: String) = locator.getLocation(ipAddress)
}