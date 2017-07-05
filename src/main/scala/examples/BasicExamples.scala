package examples

/**
  * Created by dustinvannoy on 1/16/17.
  *
  *  Examples based primarily on those used in Pluralsight course
  *   https://app.pluralsight.com/library/courses/scala-thinking-functionally
  */
object BasicExamples extends App {

  // Pattern Match (like a switch statement)
  val dayOfWeek = "Monday"
  val typeOfDay = dayOfWeek match {
    case "Monday" => "Manic Monday"
    case "Sunday" => "Sleepy Sunday"
  }

  // Tuple
  val personInfo = ("James", "Marshall", 28)
  personInfo.productIterator.foreach { i => println("Values = " + i) }
  val (first, last, age) = personInfo
  println(personInfo._1) // not great way to do this

  // List
  val weekDaysList = List("Mon", "Tue", "Wed", "Thu", "Fri")
  val weekendDaysList = List("Sat", "Sun")
  val combinedList = weekDaysList ++ weekendDaysList
  println(combinedList)
  val combinedList2 = List(weekDaysList,weekendDaysList).flatten
  println(combinedList2)

  // Map
  val states = Map(
    "California" -> "CA",
    "New York" -> "NY",
    ("Vermont", "VT") //just another way to do it
  )
  println(states("California"))
  println(states.contains("California"))
  val stateKeyList = states.keySet.toList
  val stateValuesList = states.values.toList

  // Higher order methods - simple
  // foreach (does not return anything so can't be composed or chained)
  val weekDays = List("Mon", "Tue", "Wed", "Thu", "Fri")
  weekDays.foreach(println(_))
  // map (similar to foreach but creates a list with results
  val m1 = weekDays.map(_ == "Mon")
  println(m1)
  // or as function
  val IsManicCMonday = (x: String) => {
    x == "Mon"
  }
  val m2 = weekDays.map(IsManicCMonday)
  println(m2)
  // filter
  val f1 = weekDays.filter(IsManicCMonday)
  println(f1)
  // partition (takes in expression that returns boolean and splits into 2 lists based on true/false
  val p1 = weekDays.partition(IsManicCMonday)
  println(p1)
  // sort
  val s1 = weekDays.sortBy(_(0)) // sorted by first character of each element
  println(s1)

  // Higher order methods
  // scan right (starts with right most list item)
  val someNumbers = List(10,20,30,40,50,60)
  val sc1 = someNumbers.scanRight(0)(_ - _)  // 1st param group is initial value, 2nd is function object, item1 minus item2
  println(sc1)
  // fold left (single value equal to last value in list after applying operation)
  val fo1 = someNumbers.foldLeft(0)(_ - _)
  println(fo1)
  // reduce right
  val r1 = someNumbers.reduceRight(_ - _)
  println(r1)

  // currying (from Functional Programming in Scala ch. 2)
  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    a: A => b: B => f(a: A, b: B)
  }

  // Monoids
  trait Monoid[A] {
    def op(a1: A, a2: A): A
    def zero: A
  }

  val intAddition = new Monoid[Int] {
    def op(a1: Int, a2: Int) = a1 + a2
    val zero = 0
  }


}