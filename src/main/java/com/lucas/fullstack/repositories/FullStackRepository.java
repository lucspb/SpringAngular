package com.lucas.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.fullstack.domain.FullStack;

@Repository
public interface FullStackRepository extends JpaRepository<FullStack, Integer>{

}
