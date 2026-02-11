package org.cloudstate.graphql.demo.domain;

import org.eclipse.microprofile.graphql.Ignore;

public record Person(
		int id,
		String name,
		String favoriteLocation,
		@Ignore int addressId
) {}
