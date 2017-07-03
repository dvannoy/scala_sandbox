import scala.collection.immutable.List
import scala.util.Random

/**
  * Created by dustinvannoy on 1/15/17.
  */
class RandomItemSelector(l: List[String]) {
  val itemList = l

  def buildList : List[String] = {
    val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    days
  }

  def selectRandomItem(l: List[String]): String  = {
    val rl = Random.shuffle(l)
    rl.head
  }

}
