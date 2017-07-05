
name := "scala_sandbox"

version := "1.0"

scalaVersion := "2.11.8"

val scalatestVersion = "3.0.1"
val sparkVersion = "2.1.0"
val typesafeVersion = "1.3.1"
val commonsIoVersion = "2.5"

lazy val scalaTest =  "org.scalatest" % "scalatest_2.11" % scalatestVersion
lazy val spark = "org.apache.spark" %% "spark-core" % sparkVersion
lazy val sparkSql = "org.apache.spark" % "spark-sql_2.11" % sparkVersion
lazy val sparkStreaming = "org.apache.spark" %% "spark-streaming" % sparkVersion
lazy val typesafe = "com.typesafe" % "config" % typesafeVersion
lazy val commonsIo = "commons-io" % "commons-io" % commonsIoVersion

libraryDependencies += scalaTest
libraryDependencies += spark
libraryDependencies += sparkSql
libraryDependencies += sparkStreaming
libraryDependencies += typesafe
libraryDependencies += commonsIo

lazy val `random` = (project in file("random"))
  .settings(
    name := "random",
    libraryDependencies ++= Seq(scalaTest)
  )
