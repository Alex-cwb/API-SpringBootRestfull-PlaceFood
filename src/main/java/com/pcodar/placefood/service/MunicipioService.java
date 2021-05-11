package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Municipio;
import com.pcodar.placefood.repository.MunicipioRepository;

@Service
public class MunicipioService {
	
	@Autowired
	private MunicipioRepository municipioRepository;
	
	public Municipio salvar(Municipio municipio) {
		
		Municipio municipioExistente = municipioRepository.findByMunicipio(municipio.getMunicipio());
		
		if(municipioExistente != null && !municipioExistente.equals(municipio)) {
			return municipioExistente;
		}
		
		return municipioRepository.save(municipio);
	}

}
