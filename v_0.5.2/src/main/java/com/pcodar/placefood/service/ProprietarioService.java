package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pcodar.placefood.domain.Proprietario;
import com.pcodar.placefood.exception.ContaNaoEncontradaException;
import com.pcodar.placefood.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	public Proprietario salvar(Proprietario proprietario) {		
		return proprietarioRepository.save(proprietario);
	}
	
	public void excluir(Long id_proprietario) {
		
		if(proprietarioRepository.findById(id_proprietario).isEmpty()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"Perfil de usuário não encontrado. ",
					new ContaNaoEncontradaException());
		}
		
		proprietarioRepository.deleteById(id_proprietario);
		
	}
	
}
