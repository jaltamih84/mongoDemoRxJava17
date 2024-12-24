package com.webapp.banca.demo.expose.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.webapp.banca.demo.model.domain.Document;
import com.webapp.banca.demo.model.domain.Person;
import com.webapp.banca.demo.model.entity.PersonEntity;

@Component
public class PersonMapper {

  
  public PersonEntity getPersonEntityInsertOfPerson(Person person) {
    return PersonEntity.builder()
    		.id(UUID.randomUUID().toString())
    		.firstName(person.getFirstName())
    		.lastName(person.getLastName())
    		.phoneNumber(person.getPhoneNumber())
    		.documentType(person.getDocument().getType())
    		.documentNumber(person.getDocument().getNumber())
    		.age(person.getAge())
    		.emeal(person.getEmeal())
    		.statusCivil(person.getStatusCivil())
    		.build();
  }
  
  public Person getPersonOfPersonEntity(PersonEntity personEntity) {
    return Person.builder()
    		.personaId(personEntity.getId())
    		.firstName(personEntity.getFirstName())
    		.lastName(personEntity.getLastName())
    		.phoneNumber(personEntity.getPhoneNumber())
    		.document(Document.builder()
    				.type(personEntity.getDocumentType())
    				.number(personEntity.getDocumentNumber())
    				.build())
    		.age(personEntity.getAge())
    		.emeal(personEntity.getEmeal())
    		.statusCivil(personEntity.getStatusCivil())
    		.build();
  }
}
