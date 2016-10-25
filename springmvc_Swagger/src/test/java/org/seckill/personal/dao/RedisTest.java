package org.seckill.personal.dao;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest
{
    @Test
    public void testRedis()
    {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        jedis.set("tutorial-name", "Redis tutorial");
        System.out.println("Stored string in redis:: " + jedis.get("tutorial-name"));
        jedis.close();
    }
}
