package com.immediatus

object boot extends App {

  val xs1 = 10 :: Nill
  val xs2 = 10 :: 20 :: Nill
  val xs3 = 10 :: 20 :: 30 :: Nill

  val map1 = Core.mapTo[String](xs1)
  val map2 = Core.mapTo[String](xs2)
  val map3 = Core.mapTo[String](xs3)

  println {
    xs1 + " ---> " + map1(_ + "!")
  }

  println {
    xs2 + " ---> " + map2(_ + "!")(_ + "?")
  }

  println {
    xs3 + " ---> " + map3(_ + "!")(_ + "?")(_ + "#")
  }
}

