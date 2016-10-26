package domain.chara

import domain.skill.{Skill, SkillLevel}

case class Chara(name: String,
                 race: Race,
                 raceLevel: CharaLevel,
                 classes: Map[Class, CharaLevel],
                 skills: Map[Skill, SkillLevel])
