import org.scalatest.{FunSpec, Matchers}

import scala.collection.immutable.List

/**
  * Created by dustinvannoy on 1/15/17.
  */
class RandomItemSelectorSpec extends FunSpec with Matchers {
  val rand = new RandomItemSelector(List())

  describe("When using randome item selector") {
    it("Creates a sample list") {
      val randList = rand.buildList
      val testList = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

      assert(randList == testList)
      // or
      randList should contain theSameElementsAs testList
    }
    it("Allows passing in a list") {
      val testList = List("Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado")
      val randListTest = new RandomItemSelector(testList)
      assert(randListTest.itemList == testList)
      // or
      randListTest.itemList should contain theSameElementsAs testList
    }
    it("Returns a random value from a list") {
      val testList = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

      assert(testList.contains(rand.selectRandomItem(testList)))
      // or
      testList should contain (rand.selectRandomItem(testList))
    }
  }

}
