package com.pcodar.placefood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Endereco;
import com.pcodar.placefood.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CoordenadaService coordenadaService;
	
	@Autowired
	private BairroService bairroService;
	
	@Autowired
	private NumeroService numeroService;
	
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public void excluir(Long id_endereco) {
		
		Optional<Endereco> endereco = enderecoRepository.findById(id_endereco);
		
		enderecoRepository.deleteById(id_endereco);
		
		var id_coordenadas = endereco.get().getCoordenadas().getId_coordenadas();
		coordenadaService.excluir(id_coordenadas);
		
		var id_bairro = endereco.get().getBairro().getId_bairro();
		bairroService.excluir(id_bairro);
		
		var id_numero = endereco.get().getNumero().getId_numero();
		numeroService.excluir(id_numero);
		
	}
	
}