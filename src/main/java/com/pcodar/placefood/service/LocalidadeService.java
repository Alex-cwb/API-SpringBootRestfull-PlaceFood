package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Localidade;
import com.pcodar.placefood.repository.LocalidadeRepository;

@Service
public class LocalidadeService {
	
	@Autowired
	private LocalidadeRepository localidadeRepository;
	
	public Localidade salvar(Localidade localidade) {
		
		if(localidadeRepository.equals(localidade) ) {
			return localidade;
		}
				
		return localidadeRepository.save(localidade);
	}

}
