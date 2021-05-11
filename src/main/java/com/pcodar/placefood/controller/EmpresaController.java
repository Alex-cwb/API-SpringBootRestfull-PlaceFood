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

import com.pcodar.placefood.domain.Empresa;
import com.pcodar.placefood.model.EmpresaPerfil;
import com.pcodar.placefood.repository.EmpresaRepository;
import com.pcodar.placefood.service.EmpresaPerfilService;
import com.pcodar.placefood.service.EmpresaService;

@RestController
@RequestMapping("empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaPerfilService empresaPerfilService;

	@Autowired
	private EmpresaRepository empresaRepository; 
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa criar(@Valid @RequestBody EmpresaPerfil reqBody) {
		return empresaPerfilService.salvar(reqBody);
	}
	
	@GetMapping
	public List<Empresa> listar(){
		return empresaRepository.findAll();
	}
	
	@GetMapping("/{id_empresa}")
	public ResponseEntity<Empresa> buscar(@PathVariable Long id_empresa){
		
		Optional<Empresa> empresa = empresaRepository.findById(id_empresa);
		
		return ResponseEntity.ok(empresa.get());
	}
	
	@DeleteMapping("/{id_empresa}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id_empresa) {
		empresaService.excluir(id_empresa);
	}
	
	
}
