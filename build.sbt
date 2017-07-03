
name := "scala_sandbox"

version := "1.0"

scalaVersion := "2.11.8"

//resolvers += "Artima Maven Repository" at "http://repo.artima.com/releasessb
//sbtresolvers += "Spark SQL Repository" at "https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.11"

val scalatestVersion = "3.0.1" //"2.2.6" // "3.0.1"
val sparkVersion = "2.1.0" //"2.0.0-SNAPSHOT"

lazy val scalaTest =  "org.scalatest" % "scalatest_2.11" % scalatestVersion
lazy val spark = "org.apache.spark" %% "spark-core" % sparkVersion
lazy val sparkSql = "org.apache.spark" % "spark-sql_2.11" % sparkVersion % "provided"
lazy val sparkStreaming = "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided"


//lazy val spark = sparkCore ++ Seq(
//  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
//  "org.apache.spark" %% "spark-hive" % sparkVersion % "provided",
//  "org.apache.spark" %% "spark-yarn" % sparkVersion % "provided",
//  "com.databricks" %% "spark-avro" % avroSparkVersion,
//  sparkStreamingKafka, sparkTags)

libraryDependencies += scalaTest
libraryDependencies += spark
libraryDependencies += sparkSql
libraryDependencies += sparkStreaming

lazy val `random` = (project in file("random"))
  .settings(
    name := "random",
    libraryDependencies ++= Seq(scalaTest)
  )
