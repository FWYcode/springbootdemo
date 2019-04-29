package com.utils.redisLock.imps;

import com.utils.redisLock.abstracts.AbstractDistributedLock;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/4/29 0029.
 */
public class RedisDistributedLock extends AbstractDistributedLock {
    private RedisTemplate template;
    private ThreadLocal<String> local = new ThreadLocal();
    private static final String LUA;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[" +
                "1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        LUA = sb.toString();
    }

    public RedisDistributedLock(RedisTemplate template) {
        super();
        this.template = template;
    }

    @Override
    public boolean lock(String key, long expire, int retryTimes, long sleepMillis) {
        boolean b = setRedis(key, expire);
        while (!b && retryTimes-- > 0) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            b = setRedis(key, expire);
        }
        return b;
    }

    @Override
    public boolean releaseLock(String key) {
        try {
            final List<String> keys = new ArrayList<>();
            keys.add(key);
            final List<String> args = new ArrayList<>();
            args.add(local.get());
            Long execute = (Long) template.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    Object nativeConnection = redisConnection.getNativeConnection();
                    if (nativeConnection instanceof JedisCluster) {
                        return (Long) ((JedisCluster) nativeConnection).eval(LUA, keys, args);
                    }
                    if (nativeConnection instanceof Jedis) {
                        return (Long) ((Jedis) nativeConnection).eval(LUA, keys, args);
                    }
                    return 0l;
                }
            });
            return execute!=null&&execute>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean setRedis(final String key, final long expire) {
        try {
            String result = (String) template.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    JedisCommands Connection = (JedisCommands) redisConnection.getNativeConnection();
                    String uuid = UUID.randomUUID().toString();
                    local.set(uuid);
                    String set = Connection.set(key, uuid, "NX", "PX", expire);
                    return set;
                }
            });
            return !StringUtils.isEmpty(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
