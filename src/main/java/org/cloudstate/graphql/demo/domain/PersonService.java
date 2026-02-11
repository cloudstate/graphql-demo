package org.cloudstate.graphql.demo.domain;

import static java.util.Collections.shuffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService {

	private final Map<Integer, Person> persons = new HashMap<>();
	
	public PersonService() {
		final var faker = new Faker();
		final var lotr = faker.lordOfTheRings();
			
		final var names = new HashSet<String>();
		while (names.size() < 20) {
			names.add(lotr.character());
		}
		
		var addressIds = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19));
		shuffle(addressIds);
		
		int id = 0;
		for (Iterator<String> iterator = names.iterator(); iterator.hasNext();) {
			persons.put(id, new Person(id, iterator.next(), lotr.location(), addressIds.get(id)));
			id++;
		}
	}
	
	public List<Person> all() {
		return List.copyOf(persons.values());
	}
	
	public Person byId(int id) {
		return persons.get(id);
	}
	
}
