package com.lucas.fullstack.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.fullstack.domain.FullStack;
import com.lucas.fullstack.services.FullStackService;

@RestController
@RequestMapping(value = "todos")
public class FullStackResource {
	
	@Autowired
	private FullStackService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FullStack> findById(@PathVariable int id){
		FullStack obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping(value = "/open")
	public ResponseEntity<List<FullStack>> listOpen(){
		List<FullStack> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/close")
	public ResponseEntity<List<FullStack>> listClose(){
		List<FullStack> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}
}


//localhost:8080/todos/3