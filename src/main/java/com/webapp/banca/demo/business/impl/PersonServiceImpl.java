package com.webapp.banca.demo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.banca.demo.business.PersonService;
import com.webapp.banca.demo.dao.PersonDao;
import com.webapp.banca.demo.expose.mapper.PersonMapper;
import com.webapp.banca.demo.model.domain.Person;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

@Service
public class PersonServiceImpl implements PersonService {
  
  @Autowired
  private PersonDao personDao;
  
  @Autowired
  private PersonMapper personMapper;
  
  @Override
  public Maybe<Person> insert(Person person) {
	return this.personDao.insert(this.personMapper.getPersonEntityInsertOfPerson(person))
			.map(this.personMapper::getPersonOfPersonEntity);
  }
  
  @Override
  public Maybe<Person> findById(String personId) {
	return this.personDao.findById(personId)
			.map(this.personMapper::getPersonOfPersonEntity);
  }
  
  @Override
  public Flowable<Person> findAll () {
    return this.personDao.findAll()
    		.map(this.personMapper::getPersonOfPersonEntity);
  }
  ///////////////////////////////////////////////////
  @Override
  public Maybe<Person> findByDocumentNumber(int documentNumber) {
	return this.personDao.findByDocumentNumber(documentNumber)
			.map(this.personMapper::getPersonOfPersonEntity);
  }

  @Override
  public Flowable<Person> findByLikePhoneNumber(String phoneNumber) {
    return this.personDao.findByLikePhoneNumber(phoneNumber)
	    		.map(this.personMapper::getPersonOfPersonEntity);
  }

  @Override
  public Flowable<Person> findPersonType1(int ageMin, int ageMax) {
    return this.personDao.findPersonType1(ageMin, ageMax)
	    		.map(this.personMapper::getPersonOfPersonEntity);
  }

  @Override
  public Flowable<Person> findPersonType2(String firstName, String lastName) {
    return this.personDao.findPersonType2(firstName, lastName)
	    		.map(this.personMapper::getPersonOfPersonEntity);
  }
  
}
