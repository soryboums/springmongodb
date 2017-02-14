package com.example.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String>{
	List<Person> findPersonByShortName(String shortName);
}
