package com.duing.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.102",6379);
        System.out.println(jedis.ping("hello"));
        jedis.set("a","111");
        System.out.println(jedis.get("a"));
        jedis.close();
    }
}
