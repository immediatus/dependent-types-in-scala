package com.immediatus

trait Size
trait Wrap[N <: Size] extends Size

object Size {
  trait _0 extends Size
  type _1 = Wrap[_0]
  type _2 = Wrap[_1]
  type _3 = Wrap[_2]
  type _4 = Wrap[_3]
  // ... more '_N' if needed
}


trait ListOf[+N <: Size, +H] {
  def ::[N0 >: N <: Size, H0 >: H](x : H0) : ListOf[Wrap[N0], H0] = com.immediatus.::(x, this)
}

case class ::[N <: Size, H](x : H, xs : ListOf[N, H]) extends ListOf[Wrap[N], H] {
  override def toString = s"$x, $xs"
}

trait Nill extends ListOf[Size._0, Nothing]
case object Nill extends Nill
