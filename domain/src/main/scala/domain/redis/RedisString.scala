package domain.redis

import java.util.Base64

import model.Chara
import redis.RedisClusterClient.RedisString


object RedisString {
  implicit case object CharaString extends RedisString[model.Chara] {
    override def serialize(a: Chara): String = Base64.getEncoder.encodeToString(Chara.toByteArray(a))

    override def deserialize(a: String): Chara = Chara.parseFrom(Base64.getDecoder.decode(a))
  }
}
