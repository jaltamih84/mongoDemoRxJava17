package com.webapp.banca.demo.job;


import com.webapp.banca.demo.business.ParameterService;
import com.webapp.banca.demo.business.impl.RedisService;
import com.webapp.banca.demo.model.entity.ParameterEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisSyncJob implements Job {

    @Autowired
    private ParameterService parameterService;

    @Autowired
    private RedisTemplate<String, ParameterEntity> redisTemplate;

    @Autowired
    private RedisService redisService;

    @Override
    public void execute(JobExecutionContext context) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Flowable<ParameterEntity> parametros = parameterService.findAllParameterEntity()
                .filter(p -> p.getClave().equals(p.getClave()));

        Single<List<ParameterEntity>> singleList = parametros.toList();
        List<ParameterEntity> parameterList = singleList.blockingGet();

        for (ParameterEntity parameterEntity : parameterList) {
            String redisKey = "map-parametros:" + parameterEntity.getClave();
            LocalDateTime dateParameterEntity = LocalDateTime.parse(parameterEntity.getFechaActualizacion(), formatter);

            //Si el parametro no existe en redis se carga
            if (!redisTemplate.hasKey(redisKey)) {
                LocalDateTime curreDateTime = LocalDateTime.now();
                parameterEntity.setFechaActualizacion(formatter.format(curreDateTime));
                redisTemplate.opsForValue().set("map-parametros:" + parameterEntity.getClave(), parameterEntity, 1, TimeUnit.MINUTES);
                System.out.println(">>>Parametro agregado a Redis: " + parameterEntity.getClave());
            } else {
                /*
                //Este codigo siempre actualiza el parametro existente con una fecha actual
                ParameterEntity parameterRedis = redisService.get(redisKey);
                LocalDateTime curreDateTime = LocalDateTime.now();
                parameterRedis.setFechaActualizacion(formatter.format(curreDateTime));
                redisService.put(redisKey,parameterRedis);
                System.out.println("==>Parametro actualizado en Redis: " + parameterEntity.getClave());
                */

                //Si el parametro de la BD Principal (Mongo), ha sido actualizado, se reemplaza en redis
                ParameterEntity parameterRedis = redisService.get(redisKey);
                try {
                    LocalDateTime dateParameterRedis = LocalDateTime.parse(parameterRedis.getFechaActualizacion(), formatter);
                    if (dateParameterEntity.isAfter(dateParameterRedis)) {
                        redisTemplate.opsForValue().set(redisKey, parameterEntity, 1, TimeUnit.MINUTES);
                        System.out.println("Parametro actualizado en Redis: " + parameterEntity.getClave());
                    }
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
