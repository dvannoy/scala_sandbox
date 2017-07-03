import org.apache.spark.sql.{Dataset, SparkSession}
import spark.examples.VehicleStopBase

/**
  * Created by dustinvannoy on 3/19/17.
  */
object SparkSQLExamples extends App {

  val sparkMaster = "local[*]"

  val spark = SparkSession
    .builder()
    .appName("Spark SQL Example")
    .master(sparkMaster)
    //.config("spark.some.config.option", "some-value")
    .getOrCreate()

  // For implicit conversions like converting RDDs to DataFrames
  import spark.implicits._

  val cvDF = spark.read.csv("file:///data1/tmp/vehicle_stops_2016_datasd_clean").as[VehicleStopBase]
  val r = cvDF.show()


}
