package domain.chara

import domain.core.Attributes
import domain.skill.Skill

case class Class(name: String, increasingAttributes: Attributes[Long], skillTree: List[Skill])
