package com.pcodar.placefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
}
