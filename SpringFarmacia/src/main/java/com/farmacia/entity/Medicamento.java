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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="tb_medicamento")
public class Medicamento implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_med")
	private int codMedicamento;
	@Column(name="nom_med")
	private String nomMedicamento;
	@Column(name="stock_med")
	private int stock;
	@Column(name="pre_med")
	private double precio;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_ven_med")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaVencimiento;
	//Relación muchos a uno "Laboratorio"
	@ManyToOne
	@JoinColumn(name="cod_lab")
	//atributo de la clase Laboratorio
	private Laboratorio laboratorio;//Asociación
	//relación uno a muchos "MedicamentoHasBoleta"
	@OneToMany(mappedBy="medicamento")//Asociación
	@JsonIgnore
	private List<MedicamentoHasBoleta> listaMedicamentoHasBoleta;
	
	public int getCodMedicamento() {
		return codMedicamento;
	}
	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	public String getNomMedicamento() {
		return nomMedicamento;
	}
	public void setNomMedicamento(String nomMedicamento) {
		this.nomMedicamento = nomMedicamento;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public List<MedicamentoHasBoleta> getListaMedicamentoHasBoleta() {
		return listaMedicamentoHasBoleta;
	}
	public void setListaMedicamentoHasBoleta(List<MedicamentoHasBoleta> listaMedicamentoHasBoleta) {
		this.listaMedicamentoHasBoleta = listaMedicamentoHasBoleta;
	}
	
	
}










