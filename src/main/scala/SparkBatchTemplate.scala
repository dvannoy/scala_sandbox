import java.lang.management.ManagementFactory

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dustinvannoy on 3/19/17.
  */
object SparkBatchTemplate {

  val file = "file:///data1/tmp/vehicle_stops_2016_datasd.csv" // Should be some file on your system

  val conf = new SparkConf().setAppName("Spark App")

  // Check if running from IDE, if so set master to local
  if (ManagementFactory.getRuntimeMXBean.getInputArguments.toString.contains("IntelliJ IDEA")) {
    conf.setMaster("local[*]")
  }

  def main(args: Array[String]) {
    val sc = new SparkContext(conf)

    // ADD CODE HERE


  }

}
