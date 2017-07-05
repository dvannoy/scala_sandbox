package examples

import java.lang.management.ManagementFactory

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dustinvannoy on 3/19/17.
  */
object SparkStreamingExamples {

  val logFilePath = "file:///data1/tmp/streaming_example/input" // Should be some file on your system
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

    // source from text files being added to folder
    val input = ssc.textFileStream(logFilePath)

    // source from streaming text endpoint/socket
    //val input = ssc.socketTextStream(streamingEndpointBase, port)

    input.print()

    ssc.start
    ssc.awaitTermination

  }

}
