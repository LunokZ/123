package com.farmacia.service;
import java.util.List;

import com.farmacia.entity.Boleta;
import com.farmacia.entity.MedicamentoHasBoleta;
public interface BoletaService {
	public void saveBoleta(Boleta boleta);
	
public List<Boleta> listaBoletaXNombreCliente(String nom);
	
	public List<MedicamentoHasBoleta> 
			listaDetalleBoletaXNumero(int numBoleta);
}
