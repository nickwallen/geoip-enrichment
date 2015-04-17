name         := "geoip-enrichment"
version      := "0.1.0-SNAPSHOT"
organization := "hnb"
version      := "0.1-SNAPSHOT"
scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
	"org.apache.storm" % "storm-core" % "0.9.3"
)

resolvers += "clojars.org" at "http://clojars.org/repo"
