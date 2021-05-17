package com.pcodar.placefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
	
	Pais findByPais(String pais);

}
