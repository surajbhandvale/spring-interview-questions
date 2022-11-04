package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.Person;
import com.example.repository.PersonRepository;

@Service
//@Repository
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getPersonList() {
		return personRepository.findAll();
	}
}
