import java.lang.management.ManagementFactory

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by dustinvannoy on 3/19/17.
  */
object SparkStreamingExamples {

  //val logFile = "file:///data1/tmp/vehicle_stops_2016_datasd.csv" // Should be some file on your system
  val streamingEndpointBase = "localhost"
  val port = 3001

  val conf = new SparkConf().setAppName("SparkExample1")
  val batchDuration = Seconds(4)
  // Check if running from IDE, if so set master to local
  if (ManagementFactory.getRuntimeMXBean.getInputArguments.toString.contains("IntelliJ IDEA")) {
    conf.setMaster("local[*]")
  }

  def main(args: Array[String]) {
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, batchDuration )
    //val input = sc.textFile(logFile)

    val input = ssc.socketTextStream(streamingEndpointBase, port)

    input.print()

    ssc.start
    ssc.awaitTermination

  }

}
