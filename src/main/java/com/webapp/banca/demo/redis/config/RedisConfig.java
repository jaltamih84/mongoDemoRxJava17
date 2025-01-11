package com.webapp.banca.demo.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.webapp.banca.demo.model.entity.ParameterEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, ParameterEntity> redisTemplate(RedisConnectionFactory connectionFactory,ObjectMapper objectMapper) {
        RedisTemplate<String, ParameterEntity> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Configurar serializador para valores
        Jackson2JsonRedisSerializer<ParameterEntity> serializer = new Jackson2JsonRedisSerializer<>(ParameterEntity.class);

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //serializer.setObjectMapper(objectMapper);

        // Usar StringRedisSerializer para las claves
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(serializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(serializer);
        // Agregar serializador para cadenas, enable get json object with correct structure
        template.setStringSerializer(stringSerializer);

        template.afterPropertiesSet();
        return template;
    }
}
