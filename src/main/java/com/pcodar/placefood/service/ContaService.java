package com.pcodar.placefood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pcodar.placefood.domain.Conta;
import com.pcodar.placefood.exception.ContaExistenteException;
import com.pcodar.placefood.exception.ContaNaoEncontradaException;
import com.pcodar.placefood.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	public Conta salvar(Conta conta) {
		
		Conta contaExistente = contaRepository.findByEmail(conta.getEmail());
		
		if(contaExistente != null && !contaExistente.equals(conta)) {
			throw new ResponseStatusException(
					HttpStatus.CONFLICT,
					"Já existe uma conta cadastrada com este e-mail. ",
					new ContaExistenteException());
		}
		
		return contaRepository.save(conta);
		
	}
	
	public void excluir(Long id_conta) {
		
		if(contaRepository.findById(id_conta).isEmpty()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"Conta inexistente. ",
					new ContaNaoEncontradaException());
		}
		
		Optional<Conta> conta = contaRepository.findById(id_conta);
		
		if(conta.get().getTipo_conta().equals(new String("PROPRIETARIO"))) {
			
			var idProprietario = conta.get().getProprietario();
			contaRepository.deleteById(id_conta);
			proprietarioService.excluir(idProprietario.getId_proprietario());
			
		} else {
			
			var idUsuario = conta.get().getUsuario();
			contaRepository.deleteById(id_conta);
			usuarioService.excluir(idUsuario.getId_usuario());
		}
				
		
	}
	
}
