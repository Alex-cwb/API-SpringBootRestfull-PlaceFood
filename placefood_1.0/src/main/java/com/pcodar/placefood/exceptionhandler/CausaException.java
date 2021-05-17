package com.pcodar.placefood.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CausaException {

	private Integer status;
	private OffsetDateTime data_hora;
	private String titulo;
	private List<Campo> campos;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Campo {
		
		private String campo;
		private String mensagem;
	}
	
}
