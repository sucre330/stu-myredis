package com.sucre.stu;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


public class RedisTest {
	
	private static final Log log = LogFactory.getLog(RedisTest.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();
			ShardedJedisPool shardedJedisPool = (ShardedJedisPool) context.getBean("shardedJedisPool");
			ShardedJedis jedis = shardedJedisPool.getResource();
			
			String key = "test";
			String value ="sucre";
			jedis.set(key, value);
			context.stop();
		} catch (Exception e) {
			log.error("==>RedisSpringTest context start error:", e);
			System.exit(0);
		}finally {
			log.info("===>System.exit");
			System.exit(0);
		}
	}
}
