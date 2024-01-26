package akr.redis.codemonstur.test;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.embedded.Redis;
import redis.embedded.RedisServer;

import java.io.IOException;

@Slf4j
public class RedisClientApp {

    public static void main(String[] args) throws IOException {

        RedisServer redisServer = startEmbeddedRedis();
        redisServer.start();

        try (Jedis jedis = getJedis()) {
            String key = "dog";
            jedis.set(key, "Spot");
            log.info("-------------- set value for key {}", key);
            log.info("-------------- found {} - {}", key, jedis.get(key));
        }

        redisServer.stop();

    }

    private static RedisServer startEmbeddedRedis() throws IOException {
        return new RedisServer(Redis.DEFAULT_REDIS_PORT);
    }

    private static Jedis getJedis() {
        return new JedisPool("localhost", 6379).getResource();
    }
}
