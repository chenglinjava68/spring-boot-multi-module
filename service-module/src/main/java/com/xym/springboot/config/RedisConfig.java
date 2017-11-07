package com.xym.springboot.config;

import com.xym.springboot.RedisObjectSerializer;
import com.xym.springboot.domain.RedisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Autowired
    private Environment environment;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        String hostName = environment.getProperty("spring.redis.host").trim();
        int port = Integer.parseInt(environment.getProperty("spring.redis.port").trim());
        String password = environment.getProperty("spring.redis.password").trim();
        int database = Integer.parseInt(environment.getProperty("spring.redis.database").trim());
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(hostName);
        factory.setPort(port);
        factory.setPassword(password);
        factory.setDatabase(database);
        factory.setUsePool(true);
        factory.setPoolConfig(jedisPoolConfig);
        return factory;
    }

    @Bean
    public RedisTemplate<String, RedisUser> redisTemplate() {
        RedisTemplate<String, RedisUser> template = new RedisTemplate<String, RedisUser>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
