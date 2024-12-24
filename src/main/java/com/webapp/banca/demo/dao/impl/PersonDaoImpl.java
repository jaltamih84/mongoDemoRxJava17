package com.webapp.banca.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.banca.demo.dao.PersonDao;
import com.webapp.banca.demo.dao.repository.PersonRepository;
import com.webapp.banca.demo.model.entity.PersonEntity;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import reactor.adapter.rxjava.RxJava3Adapter;

@Service
public class PersonDaoImpl implements PersonDao {
  
  @Autowired
  private PersonRepository personRepository;
  
  @Override
  public Maybe<PersonEntity> insert (PersonEntity personEntity) {
	  return RxJava3Adapter.monoToMaybe(this.personRepository.insert(personEntity));
  }
  
  @Override
  public Flowable<PersonEntity> findAll () {
	  return RxJava3Adapter.fluxToFlowable(this.personRepository.findAll());
  }
  
  @Override
  public Maybe<PersonEntity> findById (String personId) {
	  return RxJava3Adapter.monoToMaybe(this.personRepository.findById(personId));
  }
////////////////////////////////////////////////
  @Override
  public Maybe<PersonEntity> findByDocumentNumber (int documentNumber) {
	  return RxJava3Adapter.monoToMaybe(this.personRepository.findByDocumentNumber(documentNumber));
  }

  @Override
  public Flowable<PersonEntity> findByLikePhoneNumber(String phoneNumber) {
	return RxJava3Adapter.fluxToFlowable(this.personRepository.findByLikePhoneNumber(phoneNumber));
  }

  @Override
  public Flowable<PersonEntity> findPersonType1(int ageMin, int ageMax) {
    return RxJava3Adapter.fluxToFlowable(this.personRepository.findPersonType1(ageMin,ageMax));
  }

  @Override
  public Flowable<PersonEntity> findPersonType2(String firstName, String lastName) {
    return RxJava3Adapter.fluxToFlowable(this.personRepository.findByFirstNameContainingAndLastNameContaining(firstName,lastName));
  }
  
 
  
}
