package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pcodar.placefood.domain.Usuario;
import com.pcodar.placefood.exception.ContaNaoEncontradaException;
import com.pcodar.placefood.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Long id_usuario) {
		
		if(usuarioRepository.findById(id_usuario).isEmpty()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"Perfil de usuário não encontrado. ",
					new ContaNaoEncontradaException());
		}
		
		usuarioRepository.deleteById(id_usuario);
	}
}
