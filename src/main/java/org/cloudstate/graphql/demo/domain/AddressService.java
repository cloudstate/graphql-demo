package org.cloudstate.graphql.demo.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressService {

	private final Map<Integer, Address> addresses = new HashMap<>();
	
	public AddressService() {
		final var faker = new Faker();
		final var address = faker.address();
		
		final var fullAddresses = new HashSet<String>();
		while (fullAddresses.size() < 20) {
			fullAddresses.add(address.streetAddress());
		}
		
		int id = 0;
		for (Iterator<String> iterator = fullAddresses.iterator(); iterator.hasNext();) {
			addresses.put(id, new Address(id, address.city(), iterator.next()));
			id++;
		}
	}
	
	public List<Address> all() {
		return List.copyOf(addresses.values());
	}
	
	public Address byId(int id) {
		return addresses.get(id);
	}
	
}
