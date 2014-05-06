package com.immediatus

import org.specs2.mutable._
import org.specs2.specification._


class listOfSpec extends Specification {

  "val xs = 10 :: Nill" should {
    val xs = 10 :: Nill

    "interface is ListOf[_, _]" in {
      xs must haveInterface[ListOf[_, _]]
    }

    "val a :: Nill = xs" in {
      val a :: Nill = xs
      a mustEqual 10
    }
  }

  "val xs = 10 :: 20 :: Nill" should {
    val xs = 10 :: 20 :: Nill

    "interface is ListOf[_, _]" in {
      xs must haveInterface[ListOf[_, _]]
    }


    "val _ :: b :: Nill = xs" in {
      val _ :: b :: Nill = xs
      b mustEqual 20
    }
  }

}
