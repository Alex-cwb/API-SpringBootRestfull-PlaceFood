package com.pcodar.placefood.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pcodar.placefood.domain.Conta;
import com.pcodar.placefood.exception.ContaNaoEncontradaException;
import com.pcodar.placefood.model.ContaUsuario;
import com.pcodar.placefood.repository.ContaRepository;
import com.pcodar.placefood.service.ContaService;
import com.pcodar.placefood.service.PerfilContaService;

@RestController
@RequestMapping("conta-user")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private PerfilContaService perfilContaService;
	
	@Autowired
	private ContaRepository contaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Conta criar (@Valid @RequestBody ContaUsuario reqBody) {
		return perfilContaService.salvar(reqBody);
	}
	
	@GetMapping
	public List<Conta> listar() {	
		return contaRepository.findAll();
	}
	
	@GetMapping("/{id_conta}")
	public ResponseEntity<Conta> buscar(@PathVariable Long id_conta) {
			
		Optional<Conta> conta = contaRepository.findById(id_conta);
			
		if(conta.isEmpty()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"Conta não encontrada. ",
					new ContaNaoEncontradaException());
		}
			
		return ResponseEntity.ok(conta.get());
	
	}
	
	@DeleteMapping("/{id_conta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id_conta) {
		contaService.excluir(id_conta);
	}
	
	@PutMapping("/{id_conta}")
	public ResponseEntity<Conta> atualizar(@Valid @PathVariable Long id_conta,
			@RequestBody ContaUsuario reqBody) {
				
		if(contaRepository.findById(id_conta).isEmpty()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"Conta não encontrada. ",
					new ContaNaoEncontradaException());
		}
		
		var conta = perfilContaService.salvar(reqBody);
		
		return ResponseEntity.ok(conta);
	}
	
}
