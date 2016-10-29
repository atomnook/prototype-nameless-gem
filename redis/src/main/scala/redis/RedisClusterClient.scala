package redis

import com.typesafe.config.Config
import redis.RedisClusterClient.{RedisString, Setting}
import redis.clients.jedis.{HostAndPort, JedisCluster}

import scala.collection.JavaConverters._

class RedisClusterClient(setting: Setting) {
  private[redis] val client = new JedisCluster(setting.nodes.asJava)

  def set[A](key: String, a: A)(implicit s: RedisString[A]): Unit = client.set(key, s.serialize(a))

  def get[A](key: String)(implicit s: RedisString[A]): A = s.deserialize(client.get(key))

  def destroy(): Unit = {
    client.close()
  }
}

object RedisClusterClient {
  case class Setting(nodes: Set[HostAndPort])

  object Setting {
    def apply(config: Config): Setting = {
      Setting(nodes =
        config.getConfigList("nodes").asScala.map(c => new HostAndPort(c.getString("host"), c.getInt("port"))).toSet)
    }
  }

  trait RedisString[A] {
    def serialize(a: A): String

    def deserialize(a: String): A
  }
}
