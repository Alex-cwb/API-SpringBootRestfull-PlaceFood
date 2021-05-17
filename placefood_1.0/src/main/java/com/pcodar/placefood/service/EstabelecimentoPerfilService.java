package com.pcodar.placefood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcodar.placefood.domain.Bairro;
import com.pcodar.placefood.domain.Coordenadas;
import com.pcodar.placefood.domain.Endereco;
import com.pcodar.placefood.domain.Estabelecimento;
import com.pcodar.placefood.domain.Estado;
import com.pcodar.placefood.domain.Localidade;
import com.pcodar.placefood.domain.Municipio;
import com.pcodar.placefood.domain.Numero;
import com.pcodar.placefood.domain.Pais;
import com.pcodar.placefood.model.EstabelecimentoPerfil;
import com.pcodar.placefood.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoPerfilService {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private NumeroService numeroService;
	
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
	private CoordenadaService coordenadaService;
	
	@Autowired
	private EnderecoService enderecoService;

	public Estabelecimento salvar(EstabelecimentoPerfil reqBody) {
		
		var municipio = new Municipio();
		municipio.setMunicipio(reqBody.getCidade());
		
		var estado = new Estado();
		estado.setEstado(reqBody.getEstado());
		
		var pais = new Pais();
		pais.setPais(reqBody.getPais());
		
		var localidade = new Localidade();
		localidade.setMunicipio(municipioService.salvar(municipio));
		localidade.setEstado(estadoService.salvar(estado));
		localidade.setPais(paisService.salvar(pais));
		
		var bairro = new Bairro();
		bairro.setBairro(reqBody.getBairro());
		
		var numero = new Numero();
		numero.setNumero(reqBody.getNumero());
		
		var coordenadas = new Coordenadas();
		coordenadas.setLatitude(reqBody.getLatitude());
		coordenadas.setLongitude(reqBody.getLongitude());
		
		var endereco = new Endereco();
		endereco.setCep(reqBody.getCep());
		endereco.setRua(reqBody.getRua());
		endereco.setNumero(numeroService.salvar(numero));
		endereco.setBairro(bairroService.salvar(bairro));
		endereco.setLocalidade(localidadeService.salvar(localidade));
		endereco.setCoordenadas(coordenadaService.salvar(coordenadas));
		
		var estabelecimento = new Estabelecimento();
		estabelecimento.setCnpj(reqBody.getCnpj());
		estabelecimento.setNome_fantasia(reqBody.getNome_fantasia());
		estabelecimento.setEndereco(enderecoService.salvar(endereco));
		
		return estabelecimentoRepository.save(estabelecimento);
	}
	
	public void excluir(Long id_estabelecimento) {
		
		Optional<Estabelecimento> estabelecimento = 
				estabelecimentoRepository.findById(id_estabelecimento);
		
		estabelecimentoRepository.deleteById(id_estabelecimento);
		
		enderecoService.excluir(estabelecimento.get().getEndereco().getId_endereco());
			
	}
	
}
