name         := "geoip-enrichment"
version      := "0.1.0-SNAPSHOT"
organization := "hnb"
version      := "0.1-SNAPSHOT"
scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
	"org.apache.storm" % 	"storm-core" 						% "0.9.3",
  "com.sanoma.cda"   %% "maxmind-geoip2-scala" 	% "1.3.5"
)

resolvers += "clojars.org" at "http://clojars.org/repo"
