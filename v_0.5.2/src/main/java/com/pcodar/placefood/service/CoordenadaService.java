package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Coordenadas;
import com.pcodar.placefood.repository.CoordenadaRepository;

@Service
public class CoordenadaService {

	@Autowired
	private CoordenadaRepository coordenadaRepository;
	
	public Coordenadas salvar(Coordenadas coordenadas) {
		return coordenadaRepository.save(coordenadas);
	}
	
	public void excluir(Long id_coordenadas) {
		coordenadaRepository.deleteById(id_coordenadas);
	}
	
}
