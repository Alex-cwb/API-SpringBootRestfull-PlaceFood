package com.pcodar.placefood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_municipio;
	
	@Column(length = 100, nullable = true)
	private String municipio;
	
}
