package com.AtvAvaliativa12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AtvAvaliativa12.entity.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long>{
	List<Dependente> findByNome(String nome);
	

}


