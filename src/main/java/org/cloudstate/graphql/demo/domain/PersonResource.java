package org.cloudstate.graphql.demo.domain;

import java.util.List;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import jakarta.inject.Inject;

@GraphQLApi
public class PersonResource {

	@Inject
	PersonService personService;
	
	@Inject
	AddressService addressService;
	
	@Query("allPersons")
	@Description("Returns all persons")
	public List<Person> allPersons() {
		return personService.all();
	}
	
	@Query
    @Description("Get a person by id")
    public Person getPerson(@Name("personId") int id) {
        return personService.byId(id);
    }

	@Description("The person's address")
	public Address address(@Source Person person) {
		return addressService.byId(person.addressId());
	}
	
}
