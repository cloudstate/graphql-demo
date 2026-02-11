package org.cloudstate.graphql.demo.domain;

import org.eclipse.microprofile.graphql.Ignore;

public record Address(
		@Ignore int id,
		String city,
		String fullAddress
) {}
