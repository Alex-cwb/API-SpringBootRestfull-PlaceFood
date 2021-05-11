package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.HorarioFuncionamento;
import com.pcodar.placefood.repository.HorarioFuncionamentoRepository;

@Service
public class HorarioFuncionamentoService {

	@Autowired
	private HorarioFuncionamentoRepository horarioRepository;
	
	public HorarioFuncionamento salvar(HorarioFuncionamento horario) {
		return horarioRepository.save(horario);
	}
	
	
}
