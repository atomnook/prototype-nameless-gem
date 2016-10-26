package domain.skill

trait Skill {
  val id: Long
  val name: String
  val prerequisites: Map[Skill, SkillLevel]
}
