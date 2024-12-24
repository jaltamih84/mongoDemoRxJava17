package com.webapp.banca.demo.expose.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.banca.demo.business.PersonService;
import com.webapp.banca.demo.model.domain.Person;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ap/webrx/java17")
@Slf4j
public class PersonController {
	
  @Autowired
  private PersonService personService;
	
  @GetMapping(value = "/person/{personId}",
	          produces = {"application/json"})
  public Maybe<Person> getPerson(@PathVariable String personId){
    return this.personService.findById(personId);
  } 
	
	@GetMapping(value = "/persons",
            produces = {"application/json"})
  public Flowable<Person> getPersons(){
		return this.personService.findAll();
  }
	
  @PostMapping(value = "/person",
	          produces = {"application/json"})
  public Maybe<Person> postPerson(@RequestBody Person person){
    return this.personService.insert(person);
  }
  
  //////////////////////////////////////////////////////////////////
  
  @GetMapping(value = "/person/documentNumber/{documentNumber}",
          produces = {"application/json"})
  public Maybe<Person> getPersonByDocumentNumber(@PathVariable int documentNumber){
    return this.personService.findByDocumentNumber(documentNumber);
  } 
  
  @GetMapping(value = "/person/phoneNumber",
          produces = {"application/json"})
  public Flowable<Person> getPersonsByLikePhoneNumber(@RequestParam String phoneNumber){
    return this.personService.findByLikePhoneNumber(phoneNumber);
  } 
  
  
  @GetMapping(value = "/person/find-type-1",
          produces = {"application/json"})
  public Flowable<Person> getPersonsFindType1(@RequestParam int ageMin, @RequestParam int ageMax){
    return this.personService.findPersonType1(ageMin, ageMax);
  }
  
  @GetMapping(value = "/person/find-type-2",
          produces = {"application/json"})
  public Flowable<Person> getPersonsFindType2(@RequestParam String firstName, @RequestParam String lastName){
    return this.personService.findPersonType2(firstName, lastName);
  }
  
}
