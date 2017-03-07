package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		List<TollUsage> list = new ArrayList<TollUsage>();
		list.add(new TollUsage("1","H1","P1","03:00"));
		list.add(new TollUsage("2","H2","P2","03:10"));
		list.add(new TollUsage("2","H3","P3","03:20"));
		
//		return tollRepository.findAll();
		return list;
	}
	
	@RequestMapping(value="/tolls/{id}",method=RequestMethod.GET)
	public TollUsage findById(@PathVariable("id")String id){
		return tollRepository.findOne(id);
	}
	

	@RequestMapping(value="/tolls}",method=RequestMethod.POST)
	public ResponseEntity<TollUsage> save(@RequestBody TollUsage tollUsage){
		
		tollRepository.save(tollUsage);
		return new ResponseEntity<TollUsage>(tollUsage,HttpStatus.CREATED);  
	}
}
