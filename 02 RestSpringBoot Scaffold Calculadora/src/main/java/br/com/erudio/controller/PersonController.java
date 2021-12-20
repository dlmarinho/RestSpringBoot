package br.com.erudio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public List<Person> finAll() {
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public Person finbyid(@PathVariable("id") String id) {
		return service.findbyid(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE , produces= MediaType.APPLICATION_JSON_VALUE )
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE , produces= MediaType.APPLICATION_JSON_VALUE )
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delet(@PathVariable("id") String id) {
		service.delet(id);
	}
}
