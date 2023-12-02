package com.example.staffmanager.demos.redis;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@Component
public class RedisComponent {
    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis = null;

    /**
     * 获取一个Jedis实例
     */
    public Jedis getInstance() {
        if (jedis == null) {
            jedis = jedisPool.getResource();
        }
//        jedis.select(1); // 选择存储库，单机版默认为db(0)
        return jedis;
    }

    /**
     * 回收Jedis实例
     */
    public void takebackJedis(Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedis.close();
        }
    }


    public final <OUT> OUT redisExec(Function<Jedis, OUT> function) {
        Jedis jedis = null;
        try {
//            jedis = this.getInstance();
            jedis = jedisPool.getResource();
            return function.apply(jedis);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("redisExec error, errorMsg = {}", e.getMessage());
            throw e;
        } finally {
            Optional.ofNullable(jedis).ifPresent(j -> j.close());
        }
    }


    public String get(String key) {
        return this.redisExec(redis -> redis.get(key));
    }

    public <T> List<T> getCacheList(String key, Class<T> type) {
        String fhz = this.redisExec(redis -> redis.get(key));
        return JSON.parseArray(fhz,type);
    }

    public <T> T getCacheObject(String key, Class<T> type) {
        String fhz = this.redisExec(redis -> redis.get(key));
        return JSON.parseObject(fhz, type);
    }

    public Map<?,?> getCacheMap(String key) {
        String fhz = this.redisExec(redis -> redis.get(key));
        return JSON.parseObject(fhz, Map.class);
    }

    public void set(String key, String val) {
        this.redisExec(redis -> redis.set(key, val));
    }
    public void set(String key, String val, int expireSecond) {
        this.redisTxExec(tx -> {
            tx.set(key, val);
            tx.expire(key, expireSecond);
        });
    }

    public void setCacheMap(String key, Map<?,?> val) {
        String aa = JSON.toJSONString(val);
        this.redisExec(redis -> redis.set(key, aa));
    }

    public void setCacheMap(String key, Map<?,?> val, int expireSecond) {
        String aa = JSON.toJSONString(val);
        this.redisTxExec(tx -> {
            tx.set(key, aa);
            tx.expire(key, expireSecond);
        });
    }

    public void setCacheObject(String key, Object val) {
        String aa = JSON.toJSONString(val);
        this.redisExec(redis -> redis.set(key, aa));
    }

    public void setCacheList(String key, List<?> dataList) {
//        JSONObject jsonObject = JSONObject.fromObject(dataList);
        //将json转换为json字符串
        String str = JSON.toJSONString(dataList);
        this.redisExec(redis -> redis.set(key, str));
    }

    public void setCacheObject(String key, Object val, int expireSecond) {
        String aa = JSON.toJSONString(val);
        this.redisTxExec(tx -> {
            tx.set(key, aa);
            tx.expire(key, expireSecond);
        });
    }

    public Long deleteObject(String key) {
        return this.redisExec(redis -> redis.del(key));
    }

    public String flushdb() {
        return this.redisExec(redis -> redis.flushDB());
    }

    public Long del(byte[] key) {
        return this.redisExec(redis -> redis.del(key));
    }

    public Boolean hasKey(String key) {
        return this.redisExec(redis -> redis.exists(key));
    }

    public Set<String> keys(String key) {
        return this.redisExec(redis -> redis.keys(key));
    }


    public void redisTxExec(Consumer<Transaction> consumer) {
        List<Object> result = this.redisExec(jedis -> {
            Transaction tx = jedis.multi();
            consumer.accept(tx);
            return tx.exec();
        });
    }
}
