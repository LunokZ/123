package com.farmacia.dao;
import java.util.List;
import com.farmacia.entity.Laboratorio;
public interface LaboratorioDAO {
	public void insertLaboratorio(Laboratorio lab);
	public void updateLaboratorio(Laboratorio lab);
	public void deleteLaboratorio(int cod);
	public Laboratorio findLaboratorio(int cod);
	public List<Laboratorio> listLaboratorios();
}

