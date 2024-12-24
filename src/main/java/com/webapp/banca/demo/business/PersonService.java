package com.webapp.banca.demo.business;

import com.webapp.banca.demo.model.domain.Person;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface PersonService {
  Maybe<Person> insert (Person person);
  Maybe<Person> findById (String personId);
  Flowable<Person> findAll ();
  
  ////////////////////////////////////////////////////////
  
  Maybe<Person> findByDocumentNumber (int documentNumber);
  Flowable<Person> findByLikePhoneNumber (String phoneNumber);
  Flowable<Person> findPersonType1 (int ageMin, int ageMax);
  Flowable<Person> findPersonType2 (String firstName, String lastName);
  
}


