package com.farmacia.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tb_medicamento_has_boleta")
public class MedicamentoHasBoleta implements Serializable{
	//PK
	@EmbeddedId
	private MedicamentoHasBoletaPK pk;
	
	@Column(name="can")
	private int cantidad;
	@Column(name="pre")
	private double precio;
	//FK
	//relación muchos con "Medicamento"
	@ManyToOne
	@JoinColumn(name="cod_med",referencedColumnName="cod_med",
				insertable=false,updatable=false)
	private Medicamento medicamento;//asociación
	//relación muchos con "Boleta"
	@ManyToOne
	@JoinColumn(name="num_bol",referencedColumnName="num_bol",
				insertable=false,updatable=false)
	private Boleta boleta;//asociación	
	public MedicamentoHasBoletaPK getPk() {
		return pk;
	}
	public void setPk(MedicamentoHasBoletaPK pk) {
		this.pk = pk;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public Boleta getBoleta() {
		return boleta;
	}
	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
}




