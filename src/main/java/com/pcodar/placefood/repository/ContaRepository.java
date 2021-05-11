package com.pcodar.placefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	Conta findByEmail(String email);

}
