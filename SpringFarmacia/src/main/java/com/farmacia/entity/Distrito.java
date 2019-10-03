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
@Entity
@Table(name="tb_distrito")
public class Distrito implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_dis")
	private int codDistrito;
	@Column(name="nom_dis")
	private String nomDistrito;
	//relación uno a muchos "Cliente"
	@OneToMany(mappedBy="distritoCliente")//asociación
	public List<Cliente> listaClienteXDistrito;
	//relación uno a muchos "Empleado"
	@OneToMany(mappedBy="distritoEmpleado")//asociación
	private List<Empleado> listaEmpleadoXDistrito;
	
	public int getCodDistrito() {
		return codDistrito;
	}
	public void setCodDistrito(int codDistrito) {
		this.codDistrito = codDistrito;
	}
	public String getNomDistrito() {
		return nomDistrito;
	}
	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}
	public List<Cliente> getListaClienteXDistrito() {
		return listaClienteXDistrito;
	}
	public void setListaClienteXDistrito(List<Cliente> listaClienteXDistrito) {
		this.listaClienteXDistrito = listaClienteXDistrito;
	}
	public List<Empleado> getListaEmpleadoXDistrito() {
		return listaEmpleadoXDistrito;
	}
	public void setListaEmpleadoXDistrito(List<Empleado> listaEmpleadoXDistrito) {
		this.listaEmpleadoXDistrito = listaEmpleadoXDistrito;
	}
	
	
	
}






