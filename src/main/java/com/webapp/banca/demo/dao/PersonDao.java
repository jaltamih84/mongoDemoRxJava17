package com.webapp.banca.demo.dao;

import com.webapp.banca.demo.model.entity.PersonEntity;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface PersonDao {
  Maybe<PersonEntity> insert (PersonEntity person);
  Flowable<PersonEntity> findAll ();
  Maybe<PersonEntity> findById (String personId);
  
  //////////////////////////////
  
  Maybe<PersonEntity> findByDocumentNumber (int documentNumber);
  Flowable<PersonEntity> findByLikePhoneNumber (String phoneNumber);
  Flowable<PersonEntity> findPersonType1 (int ageMin, int ageMax);
  Flowable<PersonEntity> findPersonType2 (String firstName, String lastName);
  
}
