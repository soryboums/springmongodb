package com.example.service;

import java.util.Collection;

import com.example.domain.Person;

public interface PersonService {
	
	Collection<Person> getAllPersons();
	
	Person getPersonById(String id);
	
	Person createPerson(Person person);
	
	Person updatePerson(Person person);
	
	void deletePerson(String id);
	
	Collection<Person> getPersonByShortName(String shortName);

}
