package domain.core

sealed abstract class Attribute(name: String)

object Attribute {
  case object Hp extends Attribute("HP")
  case object Tp extends Attribute("TP")
  case object Str extends Attribute("STR")
  case object Vit extends Attribute("VIT")
  case object Int extends Attribute("INT")
  case object Wis extends Attribute("WIS")
  case object Agi extends Attribute("AGI")
  case object Luc extends Attribute("LUC")
}
