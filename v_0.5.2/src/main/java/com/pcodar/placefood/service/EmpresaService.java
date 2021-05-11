package com.pcodar.placefood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Empresa;
import com.pcodar.placefood.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public Empresa salvar(Empresa empresa) {		
		return empresaRepository.save(empresa);
	}
	
	public void excluir(Long id_empresa) {
		
		Optional<Empresa> empresa = empresaRepository.findById(id_empresa);
		
		empresaRepository.deleteById(id_empresa);
		
		enderecoService.excluir(empresa.get().getEndereco().getId_endereco());
				
	}

}
