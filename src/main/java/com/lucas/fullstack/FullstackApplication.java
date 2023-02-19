package com.lucas.fullstack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.fullstack.domain.FullStack;
import com.lucas.fullstack.repositories.FullStackRepository;

@SpringBootApplication
public class FullstackApplication implements CommandLineRunner{

	@Autowired
	private FullStackRepository fullStackRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		FullStack fs1 = new FullStack(null, "Estudar", "Estudar spring boot e Angular", LocalDateTime.parse("19/02/2023 12:00", formatter), false);
		
		fullStackRepository.saveAll(Arrays.asList(fs1));
	}

}
