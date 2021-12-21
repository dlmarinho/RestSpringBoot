package br.com.erudio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public List<Person> finAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Person finbyid(@PathVariable("id") Long id) {
		return service.findbyid(id);
	}
	
	@PostMapping()
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@PutMapping()
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delet(@PathVariable("id") Long id) {
		service.delet(id);
		return ResponseEntity.ok().build();
	}


}
