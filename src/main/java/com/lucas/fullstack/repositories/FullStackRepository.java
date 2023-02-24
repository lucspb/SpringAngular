package com.lucas.fullstack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucas.fullstack.domain.FullStack;

@Repository
public interface FullStackRepository extends JpaRepository<FullStack, Integer>{

	@Query("SELECT obj FROM FullStack obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
	List<FullStack> findAllOpen();

	@Query("SELECT obj FROM FullStack obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
	List<FullStack> findAllClose();

}
