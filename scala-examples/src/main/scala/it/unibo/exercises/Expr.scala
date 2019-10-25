package it.unibo.exercises

trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(l, r) => l.eval + r.eval
    case Prod(l, r) => l.eval * r.eval
  }

  def show: String = this match { // rappresentazione per le strutture. e1.show() = 3*5+7
    case Number(n) => n.toString
    case Sum(l, r) => l.show + "+" + r.show
    case Prod(l, r) => addP(l) + "*" + addP(r)
  }

  def addP(e: Expr): String = e match {
    case Sum(_, _) => s"(${e.show})"
    case _ => e.show
  }
}


case class Number(n: Int) extends Expr {
}

case class Sum(e1: Expr, e2: Expr) extends Expr {
}

case class Prod(e1: Expr, e2: Expr) extends Expr

object Expr extends App {
  val n1 = Number(4)
  val n2 = Number(5)
  val n3 = Number(42)
  val ris = Sum(n1, n2).eval

  val ris2 = Prod(Sum(n1, n2), Sum(n1, n3)).eval

  // 3*5+7
  val e1 = Sum(Prod(Number(3), Number(5)), Number(7)).eval

  // 3*(4+1)+7
  val e2 = Sum(Prod(Number(3), Sum(Number(4), Number(1))), Number(7)).eval
  val e3 = Prod(Number(3), Sum(Number(4), Number(1))).show

  println(e3)
}
