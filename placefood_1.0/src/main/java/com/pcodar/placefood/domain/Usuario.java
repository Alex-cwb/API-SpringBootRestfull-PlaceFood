package com.pcodar.placefood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private Long id_usuario;
	  
	  @Column(length = 50, nullable = false) 
	  private String nome;
	  
	  @Column(length = 50) 
	  private String sobrenome;
	  
	  @Column(nullable = false)
	  private String data_nascimento;
	  
	  @ManyToOne
	  @JoinColumn(nullable = false)
	  private Localidade localidade;
	
}
