package com.pcodar.placefood.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
	
}
