package com.pcodar.placefood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Bairro;
import com.pcodar.placefood.domain.Coordenadas;
import com.pcodar.placefood.domain.Empresa;
import com.pcodar.placefood.domain.Endereco;
import com.pcodar.placefood.domain.Estado;
import com.pcodar.placefood.domain.Localidade;
import com.pcodar.placefood.domain.Municipio;
import com.pcodar.placefood.domain.Numero;
import com.pcodar.placefood.domain.Pais;
import com.pcodar.placefood.domain.Proprietario;
import com.pcodar.placefood.model.EmpresaPerfil;
import com.pcodar.placefood.repository.ProprietarioRepository;

@Service
public class EmpresaPerfilService {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private BairroService bairroService;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private LocalidadeService localidadeService;
	
	@Autowired
	private NumeroService numeroService;
	
	@Autowired
	private CoordenadaService coordenadaSerivce;

	public Empresa salvar(EmpresaPerfil reqBody) {
		
		Optional<Proprietario> proprietario = proprietarioRepository
				.findById(reqBody.getProprietario());
		
		var numero = new Numero();
		numero.setNumero(reqBody.getNumero());
		
		var bairro = new Bairro();
		bairro.setBairro(reqBody.getBairro());
		
		var municipio = new Municipio();
		municipio.setMunicipio(reqBody.getMunicipio());
		
		var estado = new Estado();
		estado.setEstado(reqBody.getEstado());
		
		var pais = new Pais();
		pais.setPais(reqBody.getPais());
		
		var localidade = new Localidade();
		localidade.setMunicipio(municipioService.salvar(municipio));
		localidade.setEstado(estadoService.salvar(estado));
		localidade.setPais(paisService.salvar(pais));
		
		var coordenadas = new Coordenadas();
		coordenadas.setLatitude(reqBody.getLatitude());
		coordenadas.setLongitude(reqBody.getLongitude());
		
		var endereco = new Endereco();
		endereco.setCep(reqBody.getCep());
		endereco.setRua(reqBody.getRua());
		endereco.setNumero(numeroService.salvar(numero));
		endereco.setBairro(bairroService.salvar(bairro));
		endereco.setLocalidade(localidadeService.salvar(localidade));
		endereco.setCoordenadas(coordenadaSerivce.salvar(coordenadas));
		
		var empresa = new Empresa();
		empresa.setNome_empresa(reqBody.getNome_empresa());
		empresa.setCnpj(reqBody.getCnpj());
		empresa.setProprietario(proprietario.get());
		empresa.setEndereco(enderecoService.salvar(endereco));
		
		return empresaService.salvar(empresa);
	}
	
}
