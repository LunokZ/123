package com.farmacia.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farmacia.dao.LaboratorioDAO;
import com.farmacia.entity.Laboratorio;
@Service
public class LaboratorioServiceImpl implements
									LaboratorioService{
	//Declarar objeto de la interfaz que se encuentra
	//en el paquete DAO
	@Autowired
	private LaboratorioDAO laboratorioDAO;
	
	@Override
	public void insertLaboratorio(Laboratorio lab) {
		laboratorioDAO.insertLaboratorio(lab);
	}
	@Override
	public void updateLaboratorio(Laboratorio lab) {
		laboratorioDAO.updateLaboratorio(lab);
	}
	@Override
	public void deleteLaboratorio(int cod) {
		laboratorioDAO.deleteLaboratorio(cod);
	}
	@Override
	public Laboratorio findLaboratorio(int cod) {
		return laboratorioDAO.findLaboratorio(cod);
	}
	@Override
	public List<Laboratorio> listLaboratorios() {
		return laboratorioDAO.listLaboratorios();
	}

}
