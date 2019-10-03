package com.farmacia.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farmacia.entity.Laboratorio;
import com.farmacia.entity.Medicamento;
import com.farmacia.service.LaboratorioService;
import com.farmacia.service.MedicamentoService;
@Controller
@RequestMapping(value="/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	
	@RequestMapping(value="/")
	public String index() {
		return "list-medicamento";
	}
	//JSON para el combo de Laboratorio
	@RequestMapping(value="/listaLaboratorios")
	public @ResponseBody Map<String,Object> listaLaboratorios(){
		Map<String,Object> map=new HashMap<String, Object>();
		List<Laboratorio> lista=
				laboratorioService.listLaboratorios();
		//crear una clave dentro del objeto map
		map.put("dataLaboratorios", lista);
		return map;
	}
	//JSON para la tabla medicamento
	@RequestMapping(value="/listaMedicamentos")
	public @ResponseBody Map<String,Object> listaMedicamentos(){
		Map<String,Object> map=new HashMap<String, Object>();
		List<Medicamento> lista=
				medicamentoService.listMedicamentos();
		map.put("dataMedicamentos", lista);
		return map;
	}
	//JSON que retorna 1 si elimino el medicamento caso
	//contrario -1
	@RequestMapping(value="/eliminarMedicamento")
	public @ResponseBody Map<String,Object> 
		eliminarMedicamento(@RequestParam("codigo") int cod){
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			medicamentoService.deleteMedicamento(cod);
			map.put("mEliminar", 1);
		} catch (Exception e) {
			map.put("mEliminar", -1);
			e.printStackTrace();
		}
		return map;
	}	
	
	
	
	
	@RequestMapping(value="registrarMedicamento")
	public String registrarMedicamento(){
		try {
			Medicamento med=new Medicamento();
			med.setNomMedicamento("Ejemplo Sábado");
			med.setPrecio(25.26);
			med.setStock(30);
			med.setFechaVencimiento(new Date());
			//crear objeto de la Laboratorio
			Laboratorio lab=new Laboratorio();
			lab.setCodLaboratorio(2);
			//enviar el objeto "lab" al objeto "med"
			med.setLaboratorio(lab);
			medicamentoService.insertMedicamento(med);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="consulta1")
	public String consulta1(){
		try {
			List<Medicamento> lista=medicamentoService.
					listMedicamentosXLaboratorio(1);
			for(Medicamento m:lista)
				System.out.println(m.getCodMedicamento()+"-"+
									m.getNomMedicamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="consulta2")
	public String consulta2(){
		try {
			List<Medicamento> lista=medicamentoService.
					listMedicamentosXNombre("at");
			for(Medicamento m:lista)
				System.out.println(m.getCodMedicamento()+"-"+
									m.getNomMedicamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="actualizar1")
	public String actualizar1(){
		try {
			medicamentoService.actualizarPrecio(0.20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="actualizar2")
	public String actualizar2(){
		try {
			int salida=medicamentoService.actualizarPrecio(1,2);
			System.out.println("Cantidad de registros actualizados : "+salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}


