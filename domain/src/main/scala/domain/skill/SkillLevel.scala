package domain.skill

import scalaz.{-\/, \/, \/-}

sealed abstract class SkillLevel(val level: Long)

object SkillLevel {
  case object I extends SkillLevel(1)
  case object II extends SkillLevel(2)
  case object III extends SkillLevel(3)
  case object IV extends SkillLevel(4)
  case object V extends SkillLevel(5)
  case object VI extends SkillLevel(6)
  case object VII extends SkillLevel(7)
  case object VIII extends SkillLevel(8)
  case object IX extends SkillLevel(9)
  case object X extends SkillLevel(10)

  private[this] val all = Set(I, II, III, IV, V, VI, VII, VIII, IX, X)

  def apply(level: Long): \/[IllegalArgumentException, SkillLevel] = {
    all.find(_.level == level).map(\/-.apply).getOrElse(-\/(new IllegalArgumentException(s"undefined skill level $level")))
  }
}
