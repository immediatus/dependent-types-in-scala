package com.immediatus

object Core {
  trait RET[T] { type Type }
  object RET {
    import Size._
    type R[N <: Size, H, S] = RET[(ListOf[N, H], S)]
    type F[H, S] = Function1[H, S]

    implicit def list1[H, S] = new R[_1, H, S] {
      type Type = F[H, S] => ListOf[_1, S]
    }
    implicit def list2[H, S] = new R[_2, H, S] {
      type Type = F[H, S] => F[H, S] => ListOf[_2, S]
    }
    implicit def list3[H, S] = new R[_3, H, S] {
      type Type = F[H, S] => F[H, S] => F[H, S] => ListOf[_3, S]
    }
  }

  def mapTo[S] = new {
    def apply[N <: Size, H](xs : ListOf[N, H])(implicit ret : RET[(ListOf[N, H], S)]): ret.Type = {
      type F = H => S
      def $ret[X](r : X): ret.Type = r.asInstanceOf[ret.Type]

      xs match {
        case (x : H) :: Nill =>
          $ret{ (f : F) => f(x) :: Nill }

        case (x : H) :: (y : H) :: Nill =>
          $ret{ (f : F) => (g : F) => f(x) :: g(y) :: Nill }

        case (x : H) :: (y : H) :: (z : H) :: Nill =>
          $ret{ (f : F) => (g : F) => (h : F) => f(x) :: g(y) :: h(z) :: Nill }

        case _ => throw new IllegalArgumentException
      }
    }
  }
}
