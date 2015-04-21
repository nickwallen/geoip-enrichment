package hnb.chs.geoip

import backtype.storm.topology.base.BaseBasicBolt
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.BasicOutputCollector
import backtype.storm.tuple.Tuple
import backtype.storm.task.TopologyContext
import java.util.Map
import backtype.storm.tuple.Fields
import play.api.libs.json.Json
import backtype.storm.tuple.Values

class ExtractIp extends BaseBasicBolt {
  
  override def declareOutputFields(decl: OutputFieldsDeclarer) = {
    decl.declare(new Fields("ip"))
  }

  override def execute(tuple: Tuple, collector: BasicOutputCollector) = {
    val pcap = Json.parse(tuple.getStringByField("pcap"))
    
    // emit the source ip
    val sourceJson = Json.stringify(pcap \ "src")
    val sourceIp = sourceJson.replaceAll("\"", "")
    collector.emit(new Values(sourceIp))
    
    // emit the destination ip
    val destJson = Json.stringify(pcap \ "dest")
    val destIp = destJson.replaceAll("\"", "")
    collector.emit(new Values(destIp))
  }
}