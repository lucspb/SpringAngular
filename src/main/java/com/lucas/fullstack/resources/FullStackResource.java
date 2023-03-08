package com.lucas.fullstack.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<FullStack>> listAll(){
		List<FullStack> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<FullStack> create(@RequestBody FullStack obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}


//localhost:8080/todos/3