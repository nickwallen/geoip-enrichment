package hnb.chs.pcap

import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.BasicOutputCollector
import backtype.storm.tuple.Tuple
import backtype.storm.task.TopologyContext
import backtype.storm.tuple.Fields
import java.util.Map
import backtype.storm.topology.base.BaseBasicBolt

/**
 * Transforms binary pcap data to text-based json.
 */
class PcapToJson extends BaseBasicBolt {

  override def declareOutputFields(d: OutputFieldsDeclarer) = {
  }

  override def prepare(config: Map[_, _], context: TopologyContext) = {
  }

  override def execute(tuple: Tuple, collector: BasicOutputCollector) = {
  }
}