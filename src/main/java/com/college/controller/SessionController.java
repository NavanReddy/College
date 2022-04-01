package com.college.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.Session;
import com.college.repository.SessionRepo;

@RestController
@RequestMapping("/api/v1/session")
public class SessionController {

	@Autowired
	private SessionRepo sessionrepo;

	@GetMapping
	public List<Session> list() {
		return sessionrepo.findAll();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Session get(@PathVariable Long id) {
		return sessionrepo.getOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Session create(@RequestBody final Session session) {
		return sessionrepo.saveAndFlush(session);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		sessionrepo.deleteById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		Session existingSession = sessionrepo.getOne(id);
		BeanUtils.copyProperties(session, existingSession, "sessionid");
		// todo: Add validation that all atributes are passed in, otherwise return a 400
		// bad payload
		return sessionrepo.saveAndFlush(existingSession);
	}

	
}
