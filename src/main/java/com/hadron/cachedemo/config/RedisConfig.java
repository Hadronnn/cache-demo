package com.hadron.cachedemo.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @Author Hadron
 * @date 2019/8/21 16:34
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        //准备key的序列化容器
        RedisSerializationContext.SerializationPair<String> keySerializer = RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
        //准备value的序列化容器
        RedisSerializationContext.SerializationPair<Object> valueSerializer = RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
//        RedisSerializationContext.SerializationPair.fromSerializer(new GenericFastJsonRedisSerializer());
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                //设置key的序列化器
                .serializeKeysWith(keySerializer)
                //设置value的序列化器
                .serializeValuesWith(valueSerializer)
                //设置有效期
                .entryTtl(Duration.ofSeconds(1000));
                //不缓存空值,当null值进行缓存时，会出现异常
//                .disableCachingNullValues();
        RedisCacheManager cacheManager = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
                .cacheDefaults(cacheConfig)
                .build();
        return cacheManager;
    }
}
