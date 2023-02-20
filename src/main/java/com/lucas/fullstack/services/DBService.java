package com.lucas.fullstack.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.fullstack.domain.FullStack;
import com.lucas.fullstack.repositories.FullStackRepository;

@Service
public class DBService {

	@Autowired
	private FullStackRepository fullStackRepository;

	public void instanciaBaseDeDados() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		FullStack fs1 = new FullStack(null, "Estudar", "Estudar spring boot e Angular",
				LocalDateTime.parse("19/02/2023 12:00", formatter), false);

		fullStackRepository.saveAll(Arrays.asList(fs1));
	}
}
