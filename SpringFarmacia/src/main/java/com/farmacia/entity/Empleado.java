package com.farmacia.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="tb_empleado")
public class Empleado implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_emp")
	private int codEmpleado;
	@Column(name="nom_emp")
	private String nomEmpleado;
	@Column(name="ape_emp")
	private String apeEmpleado;
	@Column(name="sex_emp")
	private String sexo;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_reg_emp")
	private Date fechaRegistro;//java.util
	@Temporal(TemporalType.DATE)
	@Column(name="fec_nac_emp")
	private Date fechaNacimiento;//java.util
	@Column(name="dir_emp")
	private String direccion;
	//relación muchos a uno "Distrito"
	@ManyToOne
	@JoinColumn(name="cod_dis_emp")
	private Distrito distritoEmpleado;//asociación
	//relación uno a muchos "Boleta"
	@OneToMany(mappedBy="empleado")//asociación
	private List<Boleta> listaBoletaXEmpleado;
	
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	public String getNomEmpleado() {
		return nomEmpleado;
	}
	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}
	public String getApeEmpleado() {
		return apeEmpleado;
	}
	public void setApeEmpleado(String apeEmpleado) {
		this.apeEmpleado = apeEmpleado;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Distrito getDistritoEmpleado() {
		return distritoEmpleado;
	}
	public void setDistritoEmpleado(Distrito distritoEmpleado) {
		this.distritoEmpleado = distritoEmpleado;
	}
	public List<Boleta> getListaBoletaXEmpleado() {
		return listaBoletaXEmpleado;
	}
	public void setListaBoletaXEmpleado(List<Boleta> listaBoletaXEmpleado) {
		this.listaBoletaXEmpleado = listaBoletaXEmpleado;
	}
	
	
}









