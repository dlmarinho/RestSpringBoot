package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delet(String id) {
		
	}
	
	public Person findbyid(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirsname("Lucas");
		person.setLastname("Vieira");
		person.setAdress("Rio de Janeiro - Barra da tijuca - Brasil");
		person.setGender("Masculino");
		return person ;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8 ; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirsname("Person name" + i);
		person.setLastname("Person lastname" + i);
		person.setAdress("Person adress - Brasil" + i);
		person.setGender("Masculino" + i);
		return person ;
	}

}
