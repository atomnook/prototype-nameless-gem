package domain.redis

import domain.redis.RedisString._
import model.Chara
import org.scalatest.FlatSpec
import redis.RedisHelper

class RedisStringSpec extends FlatSpec with RedisHelper {
  "redis cluster client" should "set/get Chara" in {
    val key = "test"
    val expected = Chara(name = "chara name")

    redis.set(key, expected)

    assert(redis.get[Chara](key) == expected)
  }
}
