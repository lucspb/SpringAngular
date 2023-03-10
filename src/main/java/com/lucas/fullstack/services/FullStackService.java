package com.lucas.fullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.fullstack.domain.FullStack;
import com.lucas.fullstack.repositories.FullStackRepository;

@Service
public class FullStackService {
	
	@Autowired
	private FullStackRepository repository;
	
	public FullStack findById(int id) {
		Optional<FullStack> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<FullStack> findAllOpen() {
		List<FullStack> list = repository.findAllOpen();
		return list;
	}

	public List<FullStack> findAllClose() {
		List<FullStack> list = repository.findAllClose();
		return list;
	}

	public List<FullStack> findAll() {
		List<FullStack> list = repository.findAll();
		return list;
	}

	public FullStack create(FullStack obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		
	}
	
	

}
