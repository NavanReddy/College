package com.college.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.Session;
import com.college.model.Speaker;
import com.college.repository.SpeakerRepo;

@RestController
@RequestMapping("/api/v1/speaker")
public class SpeakerController {
	
	@Autowired
	private SpeakerRepo speakerrepo;
	
	@GetMapping
	public List<Speaker> list()
	{
		return speakerrepo.findAll();
		
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(@PathVariable Long id)
	{
		return speakerrepo.getOne(id);
		
	}
	@PostMapping
	
	public Speaker create(@RequestBody Speaker speaker)
	{
		return speakerrepo.saveAndFlush(speaker);
	}
	
	@RequestMapping(value = "{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id)
	{
		speakerrepo.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker existingSpeaker = speakerrepo.getOne(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "speakerid");
		// todo: Add validation that all atributes are passed in, otherwise return a 400
		// bad payload
		return speakerrepo.saveAndFlush(existingSpeaker);
	}

}
