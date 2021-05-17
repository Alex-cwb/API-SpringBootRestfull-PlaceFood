package com.pcodar.placefood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_conta;
		
	@Column(length = 100, nullable = false, unique = true)
	@Email
	@NotBlank
	private String email;
	
	@Column(length = 100, nullable = false)
	@NotBlank
	private String senha;
	
	@Column(length = 15, nullable = false)
	private String tipo_conta;
	
	@OneToOne
	@JoinColumn(unique = true)
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(unique = true)
	private Proprietario proprietario;
	
}
