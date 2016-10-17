package org.seckill.personal.dao.cache;

import org.seckill.personal.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao
{
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    private JedisPool jedisPool;
    
    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
    
    public RedisDao(String ip, int port)
    {
        jedisPool = new JedisPool(ip, port);
    }
    
    public Seckill getSeckill(long seckillId)
    {
        try
        {
            Jedis jedis = jedisPool.getResource();
            try
            {
                String key = "seckill:" + seckillId;
                byte[] bytes = jedis.get(key.getBytes());
                if (null != bytes)
                {
                    Seckill sk = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, sk, schema);
                    return sk;
                }
            }
            finally
            {
                jedis.close();
            }
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
    
    public String putSeckill(Seckill seckill)
    {
        try
        {
            Jedis jedis = jedisPool.getResource();
            try
            {
                String key = "seckill:" + seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill,
                    schema,
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                return jedis.setex(key.getBytes(), 60 * 60, bytes);
            }
            finally
            {
                jedis.close();
            }
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
