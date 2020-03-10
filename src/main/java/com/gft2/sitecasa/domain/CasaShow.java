package com.gft2.sitecasa.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
public class CasaShow{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message = "O nome da casa de show é obrigatório.")
	@Size(max = 60, message = "A descrição não pode conter mais de 60 caracteres.")
	private String casa;
	
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY) 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "casaShow")
	@JsonIgnore
	private  List<Eventos> listaEventos; 
	
	
	
	@NotEmpty(message = "O logradouro é obrigatório.")
	@Size(max = 60, message = "O logradouro não pode conter mais de 60 caracteres.")
	private String logradouro;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message = "A cidade é obrigatória.")
	@Size(max = 60, message = "O logradouro não pode conter mais de 60 caracteres.")
	private String cidade;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message = "A abreviação do estado é obrigatória.")
	@Size(max = 3, message = "A abreviação não pode conter mais de 3 caracteres.")
	private String estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Eventos> getListaEventos() {
		return listaEventos;
	}
	public void setListaEventos(List<Eventos> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	

}
