package com.javasm.commons.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;

/**
 * Redis基类,注册到spring容器中
 */
@Service
public class RedisService {
	private static final Logger log = LoggerFactory.getLogger(RedisService.class);

	// 注入了一个jedisPool对象
	@Resource
	private JedisPool jedisPool;

	/**
	 * 
	 * @Title: set @Description: 设置单个值 @param @param key @param @param
	 *         value @param @return @return String @throws
	 */
	public String set(String key, String value) {
		Jedis Jedis = jedisPool.getResource();

		String result = null;
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.set(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/**
	 * 
	 * @Title: get @Description: 获取单个值 @param @param key @param @return @return
	 *         String @throws
	 */
	public String get(String key) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.get(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/**
	 * 
	 * @Title: exists @Description: 确认一个key是否存在 @param @param
	 *         key @param @return @return Boolean @throws
	 */
	public Boolean exists(String key) {
		Boolean result = false;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.exists(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/**
	 * 
	 * @Title: type @Description: 返回值的类型 @param @param key @param @return @return
	 *         String @throws
	 */
	public String type(String key) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.type(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/**
	 * 
	 * @Title: expire @Description: 设定一个key的活动时间（s） @param @param key @param @param
	 *         seconds @param @return @return Long @throws
	 */
	public Long expire(String key, int seconds) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.expire(key, seconds);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/**
	 * 
	 * @Title: expireAt @Description: 在某个时间点失效 @param @param key @param @param
	 *         unixTime @param @return @return Long @throws
	 */
	public Long expireAt(String key, long unixTime) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.expireAt(key, unixTime);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/**
	 * 
	 * @Title: ttl @Description: 获得一个key的活动时间 @param @param
	 *         key @param @return @return Long @throws
	 */
	public Long ttl(String key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.ttl(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public boolean setbit(String key, long offset, boolean value) {

		boolean result = false;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.setbit(key, offset, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public boolean getbit(String key, long offset) {

		boolean result = false;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.getbit(key, offset);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public long setrange(String key, long offset, String value) {

		long result = 0;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.setrange(key, offset, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String getrange(String key, long startOffset, long endOffset) {

		String result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.getrange(key, startOffset, endOffset);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String getSet(String key, String value) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.getSet(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long setnx(String key, String value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.setnx(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String setex(String key, int seconds, String value) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.setex(key, seconds, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long decrBy(String key, long integer) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.decrBy(key, integer);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long decr(String key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.decr(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long incrBy(String key, long integer) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.incrBy(key, integer);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long incr(String key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.incr(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long append(String key, String value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.append(key, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String substr(String key, int start, int end) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.substr(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hset(String key, String field, String value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hset(key, field, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String hget(String key, String field) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hget(key, field);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hsetnx(String key, String field, String value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hsetnx(key, field, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String hmset(String key, Map<String, String> hash) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hmset(key, hash);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<String> hmget(String key, String... fields) {
		List<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hmget(key, fields);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hincrBy(String key, String field, long value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hincrBy(key, field, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Boolean hexists(String key, String field) {
		Boolean result = false;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hexists(key, field);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long del(String key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.del(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hdel(String key, String field) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hdel(key, field);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hlen(String key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hlen(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> hkeys(String key) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hkeys(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<String> hvals(String key) {
		List<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hvals(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Map<String, String> hgetAll(String key) {
		Map<String, String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hgetAll(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	// ================list ====== l表示 list或 left, r表示right====================
	/**
	 * 
	 * @Title: rpush @Description: 在指定Key所关联的List
	 *         Value的尾部插入参数中给出的所有Values。如果该Key不存在，该命令将在插入之前创建一个与该Key关联的空链表，之后再将数据从链表的尾部插入。如果该键的Value不是链表类型，该命令将返回相关的错误信息。 @param @param
	 *         key @param @param string @param @return @return Long @throws
	 */
	public Long rpush(String key, String string) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.rpush(key, string);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/**
	 * 
	 * @Title: lpush @Description: 在指定Key所关联的List
	 *         Value的头部插入参数中给出的所有Values。如果该Key不存在，该命令将在插入之前创建一个与该Key关联的空链表，之后再将数据从链表的头部插入。如果该键的Value不是链表类型，该命令将返回相关的错误信息。 @param @param
	 *         key @param @param string @param @return @return Long @throws
	 */
	public Long lpush(String key, String string) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lpush(key, string);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long lpushx(String key, String string) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lpushx(key, string);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long llen(String key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.llen(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<String> lrange(String key, long start, long end) {
		List<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lrange(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String ltrim(String key, long start, long end) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.ltrim(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String lindex(String key, long index) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lindex(key, index);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String lset(String key, long index, String value) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lset(key, index, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long lrem(String key, long count, String value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lrem(key, count, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String lpop(String key) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lpop(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String rpop(String key) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.rpop(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	// return 1 add a not exist value ,
	// return 0 add a exist value
	public Long sadd(String key, String member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sadd(key, member);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> smembers(String key) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.smembers(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long srem(String key, String member) {

		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.srem(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String spop(String key) {

		String result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.spop(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long scard(String key) {

		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.scard(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Boolean sismember(String key, String member) {

		Boolean result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sismember(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String srandmember(String key) {

		String result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.srandmember(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zadd(String key, double score, String member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zadd(key, score, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> zrange(String key, int start, int end) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrange(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zrem(String key, String member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrem(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Double zincrby(String key, double score, String member) {
		Double result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zincrby(key, score, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zrank(String key, String member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrank(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zrevrank(String key, String member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrank(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> zrevrange(String key, int start, int end) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {

			result = Jedis.zrevrange(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrangeWithScores(String key, int start, int end) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeWithScores(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrevrangeWithScores(String key, int start, int end) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeWithScores(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zcard(String key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zcard(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Double zscore(String key, String member) {
		Double result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zscore(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<String> sort(String key) {
		List<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sort(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<String> sort(String key, SortingParams sortingParameters) {
		List<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sort(key, sortingParameters);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zcount(String key, double min, double max) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zcount(key, min, max);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> zrangeByScore(String key, double min, double max) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScore(key, min, max);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> zrevrangeByScore(String key, double max, double min) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScore(key, max, min);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScore(key, min, max, offset, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
		Set<String> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScore(key, max, min, offset, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScoreWithScores(key, min, max);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScoreWithScores(key, max, min);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScoreWithScores(key, min, max, offset, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zremrangeByRank(String key, int start, int end) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zremrangeByRank(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zremrangeByScore(String key, double start, double end) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long linsert(String key, ListPosition where, String pivot, String value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.linsert(key, where, pivot, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String set(byte[] key, byte[] value) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.set(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] get(byte[] key) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.get(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Boolean exists(byte[] key) {
		Boolean result = false;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.exists(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String type(byte[] key) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.type(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long expire(byte[] key, int seconds) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.expire(key, seconds);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long expireAt(byte[] key, long unixTime) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.expireAt(key, unixTime);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long ttl(byte[] key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.ttl(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] getSet(byte[] key, byte[] value) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.getSet(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long setnx(byte[] key, byte[] value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.setnx(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String setex(byte[] key, int seconds, byte[] value) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.setex(key, seconds, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long decrBy(byte[] key, long integer) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.decrBy(key, integer);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long decr(byte[] key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.decr(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long incrBy(byte[] key, long integer) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.incrBy(key, integer);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long incr(byte[] key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.incr(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long append(byte[] key, byte[] value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.append(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] substr(byte[] key, int start, int end) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {

			result = Jedis.substr(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hset(byte[] key, byte[] field, byte[] value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hset(key, field, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] hget(byte[] key, byte[] field) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hget(key, field);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hsetnx(byte[] key, byte[] field, byte[] value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hsetnx(key, field, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String hmset(byte[] key, Map<byte[], byte[]> hash) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hmset(key, hash);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<byte[]> hmget(byte[] key, byte[]... fields) {
		List<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hmget(key, fields);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hincrBy(byte[] key, byte[] field, long value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hincrBy(key, field, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Boolean hexists(byte[] key, byte[] field) {
		Boolean result = false;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hexists(key, field);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hdel(byte[] key, byte[] field) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hdel(key, field);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long hlen(byte[] key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hlen(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> hkeys(byte[] key) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hkeys(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Collection<byte[]> hvals(byte[] key) {
		Collection<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hvals(key);
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Map<byte[], byte[]> hgetAll(byte[] key) {
		Map<byte[], byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.hgetAll(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long rpush(byte[] key, byte[] string) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.rpush(key, string);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long lpush(byte[] key, byte[] string) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lpush(key, string);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long llen(byte[] key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.llen(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<byte[]> lrange(byte[] key, int start, int end) {
		List<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lrange(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String ltrim(byte[] key, int start, int end) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.ltrim(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] lindex(byte[] key, int index) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lindex(key, index);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public String lset(byte[] key, int index, byte[] value) {
		String result = null;
		Jedis Jedis = jedisPool.getResource();

		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lset(key, index, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long lrem(byte[] key, int count, byte[] value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lrem(key, count, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] lpop(byte[] key) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.lpop(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] rpop(byte[] key) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.rpop(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long sadd(byte[] key, byte[] member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sadd(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> smembers(byte[] key) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.smembers(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long srem(byte[] key, byte[] member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.srem(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] spop(byte[] key) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.spop(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long scard(byte[] key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.scard(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Boolean sismember(byte[] key, byte[] member) {
		Boolean result = false;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sismember(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public byte[] srandmember(byte[] key) {
		byte[] result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.srandmember(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zadd(byte[] key, double score, byte[] member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zadd(key, score, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> zrange(byte[] key, int start, int end) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrange(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zrem(byte[] key, byte[] member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrem(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Double zincrby(byte[] key, double score, byte[] member) {
		Double result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zincrby(key, score, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zrank(byte[] key, byte[] member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrank(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zrevrank(byte[] key, byte[] member) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrank(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> zrevrange(byte[] key, int start, int end) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrangeWithScores(byte[] key, int start, int end) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeWithScores(key, start, end);
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrevrangeWithScores(byte[] key, int start, int end) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeWithScores(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zcard(byte[] key) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zcard(key);
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Double zscore(byte[] key, byte[] member) {
		Double result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zscore(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<byte[]> sort(byte[] key) {
		List<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sort(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
		List<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.sort(key, sortingParameters);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zcount(byte[] key, double min, double max) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zcount(key, min, max);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScore(key, min, max);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScore(key, min, max, offset, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScoreWithScores(key, min, max);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrangeByScoreWithScores(key, min, max, offset, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScore(key, max, min);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
		Set<byte[]> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScore(key, max, min, offset, count);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScoreWithScores(key, max, min);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
		Set<Tuple> result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zremrangeByRank(byte[] key, int start, int end) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {

			result = Jedis.zremrangeByRank(key, start, end);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long zremrangeByScore(byte[] key, double start, double end) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	public Long linsert(byte[] key, ListPosition where, byte[] pivot, byte[] value) {
		Long result = null;
		Jedis Jedis = jedisPool.getResource();
		if (Jedis == null) {
			return result;
		}
		try {
			result = Jedis.linsert(key, where, pivot, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			Jedis.close();
		}
		return result;
	}

	/*
	 * public List<Object> pipelined(JedisPipeline JedisPipeline) {
	 * List<Object> result = null; if (Jedis == null) { return result; }
	 * boolean broken = false; try { result =
	 * Jedis.pipelined(JedisPipeline); } catch (Exception e) {
	 * log.error(e.getMessage(), e); broken = true; } finally {
	 * redisDataSource.returnResource(Jedis, broken); } return result; }
	 */

}
