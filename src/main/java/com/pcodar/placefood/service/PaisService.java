package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Pais;
import com.pcodar.placefood.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository paisRepository;

	public Pais salvar(Pais pais) {
		
		Pais paisExistente = paisRepository.findByPais(pais.getPais());
		
		if(paisExistente != null && !paisExistente.equals(pais)) {
			return paisExistente;
		}
		
		return paisRepository.save(pais);
	}
	
}
