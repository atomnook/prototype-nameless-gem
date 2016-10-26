package domain.chara

import domain.core.Attributes
import domain.skill.Skill

case class Race(name: String,
                baseAttributes: Attributes[Long],
                increasingAttributes: Attributes[Long],
                skillTree: List[Skill])
