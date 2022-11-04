package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping("/test/{name}")
	public String test(@PathVariable("name") String name){
		return "Success - hello "+name;
	}

	@GetMapping("/persons")
	public List<Person> getAllPerson(){
		return service.getPersonList();
	}
}
