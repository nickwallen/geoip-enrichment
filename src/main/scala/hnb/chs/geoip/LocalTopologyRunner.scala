package hnb.chs.geoip

import backtype.storm.LocalCluster
import backtype.storm.Config
import backtype.storm.utils.Utils

object LocalTopologyRunner extends App {

  // configuration
  val config = new Config
  config.setDebug(true)
  
  // create the topology
  val builder = new GeoIpEnrichmentTopology
  val topology = builder.build()
  
  // create a local cluster to run the topology
  val cluster = new LocalCluster
  cluster.submitTopology("local", config, topology)
  
  // shutdown
  Utils.sleep(12000)
  cluster.killTopology("local")
  cluster.shutdown()
}