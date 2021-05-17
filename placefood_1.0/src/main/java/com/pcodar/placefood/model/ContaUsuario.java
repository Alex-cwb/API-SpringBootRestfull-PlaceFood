package com.pcodar.placefood.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaUsuario {

	@NotBlank
	private String tipoConta;
	
	@NotBlank
	@Email
	@Size(max = 100)
	private String email;
	
	@NotBlank
	@Size(max = 100)
	private String senha;
	
	@NotBlank
	@Size(max = 50)
	private String nome;
	
	@Size(max = 100)
	private String sobrenome;

	@NotBlank
	private String data_nascimento;
	
	@Size(max = 15)
	private String cpf_cnpj;
	
	@NotBlank
	@Size(max = 100)
	private String municipio;
	
	@NotBlank
	@Size(max = 100)
	private String estado;
	
	@NotBlank
	@Size(max = 100)
	private String pais;
	
}
