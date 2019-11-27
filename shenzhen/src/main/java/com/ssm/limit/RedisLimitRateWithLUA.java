package com.ssm.limit;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.io.FileUtils;

import redis.clients.jedis.Jedis;

public class RedisLimitRateWithLUA {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 11; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                        //System.out.println("请求是否被执行："+accquire());
                        System.out.println("请求是否被执行："+accquires());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        latch.countDown();
    }

    public static boolean accquire() throws IOException, URISyntaxException {
        Jedis jedis = new Jedis("127.0.0.1");
        File luaFile = new File(RedisLimitRateWithLUA.class.getResource("/").toURI().getPath() + "limit.lua");
        //InputStream inputStream = RedisLimitRateWithLUA.class.getClassLoader().getResourceAsStream("limit.lua");
        String luaScript = FileUtils.readFileToString(luaFile);

        String key = "ip:" + System.currentTimeMillis()/1000; // 当前秒
        String limit = "10"; // 最大限制
        List<String> keys = new ArrayList<String>();
        keys.add(key);
        List<String> args = new ArrayList<String>();
        args.add(limit);
        Long result = (Long)(jedis.eval(luaScript, keys, args)); // 执行lua脚本，传入参数
        return result == 1;
    }
    
    public static boolean accquires() throws IOException, URISyntaxException {
        Jedis jedis = new Jedis("127.0.0.1");
        File luaFile = new File(RedisLimitRateWithLUA.class.getResource("/").toURI().getPath() + "m.lua");
        //InputStream inputStream = RedisLimitRateWithLUA.class.getClassLoader().getResourceAsStream("limit.lua");
        String luaScript = FileUtils.readFileToString(luaFile);

        String key = "ip:" + System.currentTimeMillis()/1000; // 当前秒
        String limit = "10"; // 最大限制
        String window = "3";
        List<String> keys = new ArrayList<String>();
        keys.add(key);
        List<String> args = new ArrayList<String>();
        args.add(limit);
        args.add(window);
        //System.err.println(jedis.eval(luaScript, keys, args));
        Long result = (Long)(jedis.eval(luaScript, keys, args));
        //boolean result = Boolean.valueOf((String)jedis.eval(luaScript, keys, args)); // 执行lua脚本，传入参数
        return result == 1L;
    }
}