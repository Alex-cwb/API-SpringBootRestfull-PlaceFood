package com.pcodar.placefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcodar.placefood.domain.Coordenadas;

public interface CoordenadaRepository extends JpaRepository<Coordenadas, Long> {

}
