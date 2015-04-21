package hnb.chs.geoip

import backtype.storm.generated.StormTopology
import backtype.storm.topology.TopologyBuilder

class GeoIpEnrichmentTopology {

  def build(): StormTopology = {
    val builder = new TopologyBuilder()
    builder.setSpout("fetch-ip", new RandomPcapSpout).setNumTasks(1)
    builder.setBolt("extract-ip", new ExtractIp).shuffleGrouping("fetch-ip")
    builder.setBolt("locate-ip", new LocateIp).shuffleGrouping("extract-ip")
    builder.createTopology()
  }
}