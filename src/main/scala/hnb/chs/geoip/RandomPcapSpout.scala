package hnb.chs.geoip

import backtype.storm.topology.base.BaseRichSpout
import backtype.storm.spout.SpoutOutputCollector
import backtype.storm.task.TopologyContext
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.tuple.Fields
import scala.util.Random
import backtype.storm.tuple.Values
import play.api.libs.json.Json
import play.api.libs.json.JsObject
import play.api.libs.json.JsString
import play.api.libs.json._

class RandomPcapSpout extends BaseRichSpout {

  var collector: SpoutOutputCollector = null
  
  override def declareOutputFields(decl: OutputFieldsDeclarer) = {
    decl.declare(new Fields("pcap"))
  }
  
  override def open(config: java.util.Map[_,_], context: TopologyContext, collector: SpoutOutputCollector) = {
    this.collector = collector
  }
  
  override def nextTuple() = {
    val pcap = Json.obj("src" -> randomIp(), "dest" -> randomIp())
    collector.emit(new Values(Json.stringify(pcap)))
  }

  def randomIp() = {
//    val octets = Seq.fill(4)(Random.nextInt(256))
//    octets.mkString(".")
    "123.123.123.123"
  }
  
}