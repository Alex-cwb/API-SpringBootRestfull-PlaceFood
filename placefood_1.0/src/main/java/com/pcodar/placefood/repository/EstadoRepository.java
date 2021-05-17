package com.pcodar.placefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Estado findByEstado(String estado);
	
}
