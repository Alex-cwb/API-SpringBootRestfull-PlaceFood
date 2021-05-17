package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Numero;
import com.pcodar.placefood.repository.NumeroRepository;

@Service
public class NumeroService {

	@Autowired
	private NumeroRepository numeroRepository;
	
	public Numero salvar(Numero numero) {
		return numeroRepository.save(numero); 
	}
	
	public void excluir(Long id_numero) {
		numeroRepository.deleteById(id_numero);
	}
}
