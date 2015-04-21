name         := "geoip-enrichment"
version      := "0.1.0-SNAPSHOT"
organization := "hnb"
version      := "0.1-SNAPSHOT"
scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
	"org.apache.storm" % "storm-core" % "0.9.3",
	"net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
	"com.typesafe.play" %% "play-json" % "2.3.8"
)

resolvers += "clojars.org" at "http://clojars.org/repo"
resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"
