package com.springboot.redis.template;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands.SetOption;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
/**
 * redis 操作
 * @author yueli
 * @date:  2018年7月13日 上午11:30:39
 */
@Component
public class Redis {

	@Resource
	private RedisTemplate<?, ?> redisTemplate;

	public boolean set(final String key, final String value, long expirationTime) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				return connection.set(serializer.serialize(key), serializer.serialize(value),
						Expiration.milliseconds(expirationTime), SetOption.SET_IF_ABSENT);
			}
		});
		return result;
	}

	public long del(String key) {
		long result = redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				long n = connection.del(serializer.serialize(key));
				return n;
			}
		});
		return result;
	}

}
