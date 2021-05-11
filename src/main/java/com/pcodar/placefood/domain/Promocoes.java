package com.pcodar.placefood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Promocoes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_promo;
	
	@NotBlank
	@Column(nullable = false)
	private String titulo_promo;
	
	@NotBlank
	@Column(nullable = false)
	private String descricao;

	@NotBlank
	@Column(nullable = false)
	private String hora_abertura;
	
	@NotBlank
	@Column(nullable = false)
	private String hora_fechamento;
	
	@NotBlank
	@Column(nullable = false)
	private String valor_promo;
	
}
