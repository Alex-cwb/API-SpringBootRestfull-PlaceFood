package com.pcodar.placefood.domain;

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
public class Localidade {
	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private Long id_localidade;
	  
	  @ManyToOne
	  @JoinColumn(nullable = false) 
	  private Municipio municipio;
	  
	  @ManyToOne
	  @JoinColumn(nullable = false) 
	  private Estado estado;
	  
	 @ManyToOne
	 @JoinColumn(nullable = false) 
	 private Pais pais;
	 

}
