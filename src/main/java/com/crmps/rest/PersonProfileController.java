package com.crmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crmps.domain.Person;
import com.crmps.service.PersonProfileService;

@RestController
@RequestMapping("/profiles")
public class PersonProfileController {
	@Autowired
	private PersonProfileService personProfileService;
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add( @RequestBody Person person) {
		String uid = personProfileService.addPersonProfile(person);
		return ResponseEntity.ok("200");
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/userid/{userid}")
	Person findProfileByUserId(@PathVariable String userid) {
		return this.personProfileService.findPersonProfileForUserId(userid);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
	Person findProfileByUid(@PathVariable String id) {
		return this.personProfileService.findPersonProfileForUid(id);
	}

}
