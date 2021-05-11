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
public class Caracteristicas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_caracteristica;
	
	@NotBlank
	@Column(nullable = false)
	private String caracteristica;
	
}
