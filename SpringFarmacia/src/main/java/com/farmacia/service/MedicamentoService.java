package com.farmacia.service;
import java.util.List;
import com.farmacia.entity.Medicamento;
public interface MedicamentoService {
	public void insertMedicamento(Medicamento med);
	public void updateMedicamento(Medicamento med);
	public void deleteMedicamento(int cod);
	public Medicamento findMedicamento(int cod);
	public List<Medicamento> listMedicamentos();
	
	public List<Medicamento> listMedicamentosXLaboratorio(int codLab);
	public List<Medicamento> listMedicamentosXNombre(String nom);
	public void actualizarPrecio(double porcentaje);
	public int actualizarPrecio(int codLab,int cantidad);
}

