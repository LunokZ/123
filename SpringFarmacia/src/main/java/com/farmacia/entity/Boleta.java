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
@Table(name="tb_boleta")
public class Boleta implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_bol")
	private int numBoleta;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_emi_bol")
	private Date fechaEmision;//java.util
	@Column(name="monto_bol")
	private double monto;
	//relación muchos a uno "Cliente"
	@ManyToOne
	@JoinColumn(name="cod_cli")
	private Cliente cliente;//asociación
	//relación muchos a uno "Empleado"
	@ManyToOne
	@JoinColumn(name="cod_emp")
	private Empleado empleado;//asociación	
	//relación uno a muchos "MedicamentoHasBoleta"
	@OneToMany(mappedBy="boleta")
	private List<MedicamentoHasBoleta> listaMedicamentosXBoleta;
	
	public int getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public List<MedicamentoHasBoleta> getListaMedicamentosXBoleta() {
		return listaMedicamentosXBoleta;
	}
	public void setListaMedicamentosXBoleta(List<MedicamentoHasBoleta> listaMedicamentosXBoleta) {
		this.listaMedicamentosXBoleta = listaMedicamentosXBoleta;
	}
	
}




