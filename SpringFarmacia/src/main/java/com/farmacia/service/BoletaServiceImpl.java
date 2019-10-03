package com.farmacia.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farmacia.dao.BoletaDAO;
import com.farmacia.entity.Boleta;
import com.farmacia.entity.MedicamentoHasBoleta;
@Service
public class BoletaServiceImpl implements BoletaService{
	@Autowired
	private BoletaDAO boletaDAO;
	
	@Override
	public void saveBoleta(Boleta boleta) {
		boletaDAO.saveBoleta(boleta);
	}

	@Override
	public List<Boleta> listaBoletaXNombreCliente(String nom) {
		// TODO Auto-generated method stub
		return boletaDAO.listaBoletaXNombreCliente(nom);
	}

	@Override
	public List<MedicamentoHasBoleta> listaDetalleBoletaXNumero(int numBoleta) {
		// TODO Auto-generated method stub
		return boletaDAO.listaDetalleBoletaXNumero(numBoleta);
	}
	
}


