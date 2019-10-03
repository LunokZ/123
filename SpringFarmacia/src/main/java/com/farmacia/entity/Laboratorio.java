package com.farmacia.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="tb_laboratorio")
public class Laboratorio implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_lab")
	private int codLaboratorio;
	@Column(name="des_lab")
	private String desLaboratorio;
	//relación uno a muchos con "Medicamento"
	@OneToMany(mappedBy="laboratorio")//asociación
	//lista de medicamento
	@JsonIgnore
	private List<Medicamento> listaMedicamentos;
	
	public int getCodLaboratorio() {
		return codLaboratorio;
	}
	public void setCodLaboratorio(int codLaboratorio) {
		this.codLaboratorio = codLaboratorio;
	}
	public String getDesLaboratorio() {
		return desLaboratorio;
	}
	public void setDesLaboratorio(String desLaboratorio) {
		this.desLaboratorio = desLaboratorio;
	}
	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}
	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}
	
	
}



