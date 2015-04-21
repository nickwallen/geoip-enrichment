package hnb.chs.geoip

import backtype.storm.topology.base.BaseBasicBolt
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.BasicOutputCollector
import backtype.storm.tuple.Tuple
import backtype.storm.task.TopologyContext
import backtype.storm.tuple.Fields
import backtype.storm.tuple.Values
import scala.collection.Map
import backtype.storm.generated.StormTopology
import dispatch._, Defaults._

class LocateIp extends BaseBasicBolt {

  // TODO - add to global configuration
  val serviceHost = "http://localhost:9000"

  override def declareOutputFields(decl: OutputFieldsDeclarer) = {
    decl.declare(new Fields("ip", "location"))
  }

  override def execute(tuple: Tuple, collector: BasicOutputCollector) = {
    val ip = tuple.getStringByField("ip")
    val service = url(s"$serviceHost/locate/$ip")
    val request = Http(service OK as.String)
    val location = request()

    collector.emit(new Values(ip, location))
  }
}