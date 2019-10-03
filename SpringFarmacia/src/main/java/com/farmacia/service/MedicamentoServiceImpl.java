package com.farmacia.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farmacia.dao.MedicamentoDAO;
import com.farmacia.entity.Medicamento;
@Service
public class MedicamentoServiceImpl implements 
					MedicamentoService{
	@Autowired
	private MedicamentoDAO medicamentoDAO;
	
	@Override
	public void insertMedicamento(Medicamento med) {
		medicamentoDAO.insertMedicamento(med);
	}
	@Override
	public void updateMedicamento(Medicamento med) {
		medicamentoDAO.updateMedicamento(med);
	}
	@Override
	public void deleteMedicamento(int cod) {
		medicamentoDAO.deleteMedicamento(cod);
	}
	@Override
	public Medicamento findMedicamento(int cod) {
		return medicamentoDAO.findMedicamento(cod);
	}
	@Override
	public List<Medicamento> listMedicamentos() {
		return medicamentoDAO.listMedicamentos();
	}
	@Override
	public List<Medicamento> listMedicamentosXLaboratorio(int codLab) {
		// TODO Auto-generated method stub
		return medicamentoDAO.listMedicamentosXLaboratorio(codLab);
	}
	@Override
	public List<Medicamento> listMedicamentosXNombre(String nom) {
		// TODO Auto-generated method stub
		return medicamentoDAO.listMedicamentosXNombre(nom);
	}
	@Override
	public void actualizarPrecio(double porcentaje) {
		medicamentoDAO.actualizarPrecio(porcentaje);
		
	}
	@Override
	public int actualizarPrecio(int codLab, int cantidad) {
		// TODO Auto-generated method stub
		return medicamentoDAO.actualizarPrecio(codLab, cantidad);
	}

}
