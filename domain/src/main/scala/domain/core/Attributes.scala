package domain.core

import domain.core.Attribute._

case class Attributes[A] private(values: Map[Attribute, A])

object Attributes {
  def apply[A](hp: A, tp: A, str: A, vit: A, int: A, wis: A, agi: A, luc: A): Attributes[A] = {
    Attributes(values = Map(Hp -> hp, Tp -> tp, Str -> str, Vit -> vit, Int -> int, Wis -> wis, Agi -> agi, Luc -> luc))
  }
}
