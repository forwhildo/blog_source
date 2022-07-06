package top.aday.redis_cache.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import top.aday.redis_cache.util.ApplicationContextUtils;

public class RedisCache implements Cache {

    private final String id;

    public RedisCache(String id){
        this.id = id ;
    }

    //返回缓存空间唯一标识
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        System.out.println("============key:" + key.toString());
        System.out.println("============value:" + value);

        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.opsForHash().put(id,key.toString(),value);
    }

    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        return redisTemplate.opsForHash().get(id,key.toString());
     }

    @Override
    public Object removeObject(Object key) {
        /*不会调用*/
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.delete(id);
    }

    @Override
    public int getSize() {
        RedisTemplate redisTemplate = getRedisTemplate();
        return redisTemplate.opsForHash().size(id).intValue();
    }

    private RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}