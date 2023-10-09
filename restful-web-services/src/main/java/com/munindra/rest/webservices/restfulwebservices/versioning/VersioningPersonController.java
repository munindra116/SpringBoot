package com.munindra.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob","charlie"));
	}
	@GetMapping(path = "/person" , params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path = "/person" , params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter2() {
		return new PersonV2(new Name("Bob","charlie"));
	}
	@GetMapping(path = "/person/header" , headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path = "/person/header" , headers = "X-API-VERSION=2")
	public PersonV2 getFirstVersionOfPersonRequestHeader2() {
		return new PersonV2(new Name("Bob","charlie"));
	}
	@GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonRequestAcceptHeader1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v2+json")
	public PersonV2 getFirstVersionOfPersonRequestAcceptHeader2() {
		return new PersonV2(new Name("Bob","charlie"));
	}
	

}
