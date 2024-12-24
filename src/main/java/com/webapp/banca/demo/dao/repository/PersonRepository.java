package com.webapp.banca.demo.dao.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webapp.banca.demo.model.entity.PersonEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PersonRepository extends ReactiveMongoRepository<PersonEntity, String> {
	
  Mono<PersonEntity> findByDocumentNumber(int documentNumber);
  /////////////////////////////////////////////////////
  //like
  @Query("{ phoneNumber : { $regex : ?0 } }")
  Flux<PersonEntity> findByLikePhoneNumber(String phoneNumber);
  
  //like
  @Query("{ age : { $lte : :#{#ageMax} , $gte : :#{#ageMin}  } }")
  Flux<PersonEntity> findPersonType1(int ageMin, int ageMax);
  
  Flux<PersonEntity> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
  
}
