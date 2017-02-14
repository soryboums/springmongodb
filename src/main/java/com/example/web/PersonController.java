package com.example.web;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Person;
import com.example.service.PersonService;


@RestController
@RequestMapping ("/api")  // We are binding request starting with "/api" to this class
public class PersonController {
	@Resource
	private PersonService personService;
	
	// "api/person" with a POST request	
	@RequestMapping(method = RequestMethod.POST, value = "/person" )
	public Person createPerson(@RequestBody Person person){
		return this.personService.createPerson(person);
	}
	
	// "api/person" with a GET request	
	@RequestMapping(method = RequestMethod.GET, value = "/person")
	public Collection<Person> getAllPersons(){
		return this.personService.getAllPersons();
	}
	// "api/person/shortname/{shortName}" with a GET request
	@RequestMapping(method = RequestMethod.GET, value = "/person/shortname/{shortName}")
	public Collection<Person> getPersonByShortName (@PathVariable(value="shortName") String shortName){
		return this.personService.getPersonByShortName(shortName);
	}
	
	// "api/person/{id}" with a GET request
	@RequestMapping(method = RequestMethod.GET, value = "/person/{id}")
	public Person getPersonById (@PathVariable(value="id") String id){
		return this.personService.getPersonById(id);
	}
	// "api/person/{id}" with a DELETE request
	@RequestMapping(method = RequestMethod.DELETE, value = "/person/{id}")
	public String deletePerson(@PathVariable(value = "id") String id){
		this.personService.deletePerson(id);
		return id;
	}
	
	// "api/person/{id}" with a PUT request
	@RequestMapping(method = RequestMethod.PUT, value = "/person/{id}")
	public Person updatePerson(@PathVariable(value = "id") String id, @RequestBody Person person){
		person.setId(id);
		return this.personService.updatePerson(person);
	}
}
