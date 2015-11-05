name := "modern-web-template"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

pipelineStages := Seq(uglify, digest, gzip)

pipelineStages in Assets := Seq()

pipelineStages := Seq(uglify, digest, gzip)

DigestKeys.algorithms += "sha1"

UglifyKeys.uglifyOps := { js =>
  Seq((js.sortBy(_._2), "concat.min.js"))
}


resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.0",
  "javax.inject" % "javax.inject" % "1",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.7.play24",
  "org.webjars" % "bootstrap" % "3.3.4",
  "org.webjars" % "angularjs" % "1.3.15",
  "org.webjars" % "angular-ui-bootstrap" % "0.13.0",
  "org.specs2"  %% "specs2-core" % "3.6.5" % "test",
  "org.specs2"  %% "specs2-mock" % "3.6.5" % "test",
  "org.specs2"  %% "specs2-junit" % "3.6.5" % "test"
)


fork in run := true