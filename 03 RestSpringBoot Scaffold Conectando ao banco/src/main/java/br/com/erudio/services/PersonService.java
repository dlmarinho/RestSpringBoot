package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll() {
		
		return repository.findAll() ;
	}
	
	public Person findbyid(Long id) {
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos nenhum resgistro com esse id"));
		
	}
	
	public Person update(Person person) {
		Person Entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Não encontramos nenhum resgistro com esse id"));
		
		Entity.setFirsname(person.getFirsname());
		Entity.setLastname(person.getLastname());
		Entity.setAdress(person.getAdress());
		Entity.setGender(person.getGender());
		
		return repository.save(Entity) ;
	}
	
	public void delet(Long id) {
		Person Entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos nenhum resgistro com esse id"));
		repository.delete(Entity);
	}
}
