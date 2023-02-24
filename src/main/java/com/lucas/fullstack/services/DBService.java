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

		FullStack fs1 = new FullStack(null, "Academia", "Ir Treinar", LocalDateTime.parse("24/02/2023 06:00", formatter), true);
		FullStack fs2 = new FullStack(null, "Trabalhar", "Trabalhar home-office", LocalDateTime.parse("24/02/2023 08:00", formatter), false);
		FullStack fs3 = new FullStack(null, "Estudar", "Estudar spring boot e Angular", LocalDateTime.parse("24/02/2023 18:00", formatter), false);
		FullStack fs4 = new FullStack(null, "Duolingo", "Praticar o Duolingo", LocalDateTime.parse("24/02/2023 22:00", formatter), false);
		
		fullStackRepository.saveAll(Arrays.asList(fs1, fs2, fs3, fs4));
	}
}
