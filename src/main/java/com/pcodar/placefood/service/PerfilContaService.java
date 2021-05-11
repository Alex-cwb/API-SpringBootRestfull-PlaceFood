package com.pcodar.placefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Conta;
import com.pcodar.placefood.domain.Estado;
import com.pcodar.placefood.domain.Localidade;
import com.pcodar.placefood.domain.Municipio;
import com.pcodar.placefood.domain.Pais;
import com.pcodar.placefood.domain.Proprietario;
import com.pcodar.placefood.domain.Usuario;
import com.pcodar.placefood.model.ContaUsuario;

@Service
public class PerfilContaService {
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private LocalidadeService localidadeService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	@Autowired
	private ContaService contaService;

	public Conta salvar(ContaUsuario reqBody) {
		
		var conta = new Conta();
		
		if(reqBody.getTipoConta().equals(new String("PROPRIETARIO"))) {
			conta = perfilProprietario(reqBody);
			
		} else {
			conta = perfilUsuario(reqBody);
			
		}
		
		return conta;
	}
	
	private Conta perfilUsuario(ContaUsuario perfil) {
		
		var pais = new Pais(); 
		pais.setPais(perfil.getPais()); 
		
		var estado = new Estado(); 
		estado.setEstado(perfil.getEstado()); 
		
		var municipio = new Municipio();
		municipio.setMunicipio(perfil.getMunicipio()); 
		
		var localidade = new Localidade();
		localidade.setMunicipio(municipioService.salvar(municipio));
		localidade.setEstado(estadoService.salvar(estado)); 
		localidade.setPais(paisService.salvar(pais));
				 
		var usuario = new Usuario();
		usuario.setNome(perfil.getNome());
		usuario.setSobrenome(perfil.getSobrenome());
		usuario.setData_nascimento(perfil.getData_nascimento());
		usuario.setLocalidade(localidadeService.salvar(localidade));
		
		var conta = new Conta();
		conta.setEmail(perfil.getEmail());
		conta.setSenha(perfil.getSenha());
		conta.setTipo_conta(perfil.getTipoConta());
		conta.setUsuario(usuarioService.salvar(usuario));
		
		return contaService.salvar(conta);
	}
	
	private Conta perfilProprietario(ContaUsuario perfil) {
		
		var pais = new Pais(); 
		pais.setPais(perfil.getPais()); 
		
		var estado = new Estado(); 
		estado.setEstado(perfil.getEstado()); 
		
		var municipio = new Municipio();
		municipio.setMunicipio(perfil.getMunicipio()); 
		
		var localidade = new Localidade();
		localidade.setMunicipio(municipioService.salvar(municipio));
		localidade.setEstado(estadoService.salvar(estado)); 
		localidade.setPais(paisService.salvar(pais));
		
		var proprietario = new Proprietario();
		proprietario.setNome(perfil.getNome());
		proprietario.setSobrenome(perfil.getSobrenome());
		proprietario.setCpf_cnpj(perfil.getCpf_cnpj());
		proprietario.setDataNascimento(perfil.getData_nascimento());
		proprietario.setLocalidade(localidadeService.salvar(localidade));
		
		var conta = new Conta();
		conta.setEmail(perfil.getEmail());
		conta.setSenha(perfil.getSenha());
		conta.setTipo_conta(perfil.getTipoConta());
		conta.setProprietario(proprietarioService.salvar(proprietario));
		
		return contaService.salvar(conta);
	}
	
}
