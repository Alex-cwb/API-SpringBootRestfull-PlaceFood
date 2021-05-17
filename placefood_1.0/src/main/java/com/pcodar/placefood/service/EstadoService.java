package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Estado;
import com.pcodar.placefood.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		
		Estado estadoExistente = estadoRepository.findByEstado(estado.getEstado());
		
		if(estadoExistente != null && !estadoExistente.equals(estado)) {
			return estadoExistente;
		}
		
		return estadoRepository.save(estado);
	}

}
