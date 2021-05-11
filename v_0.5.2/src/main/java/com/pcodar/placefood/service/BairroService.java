package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Bairro;
import com.pcodar.placefood.repository.BairroRepository;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;
	
	public Bairro salvar(Bairro bairro) {
		return bairroRepository.save(bairro); 		
	}
	
	public void excluir(Long id_bairro) {
		bairroRepository.deleteById(id_bairro);
	}
	
}
