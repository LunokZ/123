package com.farmacia.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farmacia.entity.Laboratorio;
import com.farmacia.service.LaboratorioService;
@Controller
public class LaboratorioController {
	@Autowired
	private LaboratorioService laboratorioDAO;
	
	@RequestMapping(value="/registrarLaboratorio")
	public String registrarLaboratorio() {
		try {
			Laboratorio lab=new Laboratorio();
			lab.setDesLaboratorio("AAA");
			laboratorioDAO.insertLaboratorio(lab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="/actualizarLaboratorio")
	public String actualizarLaboratorio() {
		try {
			Laboratorio lab=new Laboratorio();
			lab.setCodLaboratorio(9);
			lab.setDesLaboratorio("Prueba");
			laboratorioDAO.updateLaboratorio(lab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="/eliminarLaboratorio")
	public String eliminarLaboratorio() {
		try {
			laboratorioDAO.deleteLaboratorio(9);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="/buscarLaboratorio")
	public String buscarLaboratorio() {
		try {
			Laboratorio lab;
			lab=laboratorioDAO.findLaboratorio(2);
			System.out.println(lab.getCodLaboratorio()+
						"---"+lab.getDesLaboratorio());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="/listarLaboratorio")
	public String listarLaboratorio() {
		try {
			List<Laboratorio> lista;
			lista=laboratorioDAO.listLaboratorios();
			for(Laboratorio lab:lista)
			 System.out.println(lab.getCodLaboratorio()+
						"---"+lab.getDesLaboratorio());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}


