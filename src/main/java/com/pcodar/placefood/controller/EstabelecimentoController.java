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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pcodar.placefood.domain.Estabelecimento;
import com.pcodar.placefood.model.EstabelecimentoPerfil;
import com.pcodar.placefood.repository.EstabelecimentoRepository;
import com.pcodar.placefood.service.EstabelecimentoPerfilService;

@RestController
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoPerfilService estabelecimentoPerfilService;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estabelecimento salvar(@Valid @RequestBody EstabelecimentoPerfil reqBody) {	
		return estabelecimentoPerfilService.salvar(reqBody);
	}
	
	@GetMapping
	public List<Estabelecimento> listar() {
		return estabelecimentoRepository.findAll();
	}
	
	@GetMapping("/{id_estabelecimento}")
	public ResponseEntity<Estabelecimento> buscar(@PathVariable Long id_estabelecimento) {
		
		Optional<Estabelecimento> estabelecimento = 
				estabelecimentoRepository.findById(id_estabelecimento);
		
		return ResponseEntity.ok(estabelecimento.get());
	}
	
	@DeleteMapping("/{id_estabelecimento}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id_estabelecimento) {
		estabelecimentoPerfilService.excluir(id_estabelecimento);
	}

}
