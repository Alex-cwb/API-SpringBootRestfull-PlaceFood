package com.pcodar.placefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	
	Municipio findByMunicipio(String municipio);

}
