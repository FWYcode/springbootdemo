//package com.utils.redisLock;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.JedisCommands;
//
///**
// * Created by Administrator on 2019/4/29 0029.
// */
//@Component
//public class RedisLock {
//    @Autowired
//    private RedisTemplate template;
//
//    public boolean lock(final String key) {
//        String execute =(String) template.execute(new RedisCallback<String>(){
//
//            @Override
//            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                return null;
//            }
//        });
//
//        return false;
//    }
//}
