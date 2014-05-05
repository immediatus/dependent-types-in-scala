package com.immediatus

import org.specs2.mutable._
import org.specs2.specification._


class dependentTypeSpec extends Specification {

  "val xs = 10 :: Nill" should {
    val xs = 10 :: Nill

    """mapTo[String](xs)(_ + "!")""" in {
      val hfunctor = Core.mapTo[String](xs)
      hfunctor(_ + "!") mustEqual "10!" :: Nill
    }

    """mapTo[Int](xs)(_ * 2)""" in {
      val hfunctor = Core.mapTo[Int](xs)
      hfunctor(_ * 2) mustEqual 20 :: Nill
    }
  }

  "val xs = 10 :: 20 :: Nill" should {
     val xs = 10 :: 20 :: Nill

    """mapTo[String](xs)(_ + "!")(_ + "?")""" in {
      val hfunctor = Core.mapTo[String](xs)
      hfunctor(_ + "!")(_ + "?") mustEqual "10!" :: "20?" :: Nill
    }

    """mapTo[Int](xs)(_ * 2)(_ / 2)""" in {
      val hfunctor = Core.mapTo[Int](xs)
      hfunctor(_ * 2)(_ / 2) mustEqual 20 :: 10 :: Nill
    }
  }

}
