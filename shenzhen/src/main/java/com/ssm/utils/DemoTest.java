package com.ssm.utils;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.ssm.test.TestObject;

public class DemoTest extends BaseTest {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDel(){
		//redisTemplate.delete("2");
        Set<Object> keys = redisTemplate.keys("msgId:" + "*");
        redisTemplate.delete(keys);
        redisTemplate.delete("msgId:84877");
	}
}
