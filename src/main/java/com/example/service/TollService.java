package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TollUsage;
import com.example.model.repository.TollRepository;

@RestController()
public class TollService {

	@Autowired
	private TollRepository tollRepository;
	
	@RequestMapping(value="/tolls",method=RequestMethod.GET)
	public List<TollUsage> findAll(){
		return tollRepository.findAll();
	}
	
	@RequestMapping(value="/tolls/{id}",method=RequestMethod.GET)
	public TollUsage findById(@PathVariable("id")String id){
		return tollRepository.findOne(id);
	}
}
