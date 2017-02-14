package com.example.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.stereotype.Service;

import com.example.domain.Person;
import com.example.domain.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Resource
	private PersonRepository personRepository;
	
	@Override
	public Collection<Person> getAllPersons(){
		return IteratorUtils.toList(this.personRepository.findAll().iterator());
	};
	
	@Override
	public Person getPersonById(String id){
		return this.personRepository.findOne(id);
	};
	
	@Override
	public Person createPerson(Person person){
		return this.personRepository.save(person);
	};
	
	@Override
	public Person updatePerson(Person person){
		return this.personRepository.save(person);
	};
	
	@Override
	public void deletePerson(String id){
		this.personRepository.delete(id);
	};
	
	@Override
	public Collection<Person> getPersonByShortName(String shortName){
		return this.personRepository.findPersonByShortName(shortName);
	};

}
