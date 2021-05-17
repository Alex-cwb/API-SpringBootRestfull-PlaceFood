package com.pcodar.placefood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_endereco;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String rua;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Numero numero;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Bairro bairro;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Localidade localidade;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Coordenadas coordenadas;
	
}
