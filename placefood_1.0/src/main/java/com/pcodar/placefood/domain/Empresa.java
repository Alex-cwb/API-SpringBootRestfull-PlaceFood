package com.pcodar.placefood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;
	
	@NotBlank
	@Column(nullable = false)
	private String nome_empresa;

	@NotBlank
	@Column(nullable = false)
	private String cnpj;
	
	@OneToOne
	@JoinColumn(nullable = false, unique = true)
	private Proprietario proprietario;

	@OneToOne
	@JoinColumn(nullable = false)
	private Endereco endereco;

}
