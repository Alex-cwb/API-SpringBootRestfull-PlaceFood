package com.pcodar.placefood.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoPerfil {
	
	private Long id_empresa;
	
	private String nome_fantasia;
	
	private String cnpj;
	
	private String cep;
	
	private String rua;
	
	private String numero;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	private String pais;
	
	private String latitude;
	
	private String longitude;	
	
}
