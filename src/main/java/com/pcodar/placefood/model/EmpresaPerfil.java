package com.pcodar.placefood.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaPerfil {

	private Long proprietario;
	
	@NotBlank
	@Size(max = 100)
	private String nome_empresa;
	
	@NotBlank
	@Size(max = 15)
	private String cnpj;
	
	@NotBlank
	@Size(max = 10)
	private String cep;
	
	@NotBlank
	@Size(max = 100)
	private String rua;
	
	@NotBlank
	@Size(max = 10)
	private String numero;
	
	@NotBlank
	@Size(max = 50)
	private String bairro;
	
	@NotBlank
	@Size(max = 100)
	private String municipio;
	
	@NotBlank
	@Size(max = 50)
	private String estado;
	
	@NotBlank
	@Size(max = 50)
	private String pais;
	
	@NotBlank
	private String latitude;

	@NotBlank
	private String longitude;
	
}
