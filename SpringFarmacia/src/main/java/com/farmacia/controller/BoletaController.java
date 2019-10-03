package com.farmacia.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farmacia.entity.Boleta;
import com.farmacia.entity.Cliente;
import com.farmacia.entity.Empleado;
import com.farmacia.entity.Medicamento;
import com.farmacia.entity.MedicamentoHasBoleta;
import com.farmacia.entity.MedicamentoHasBoletaPK;
import com.farmacia.service.BoletaService;
@Controller
public class BoletaController {
	@Autowired
	private BoletaService boletaService;
	
	@RequestMapping(value="/registrarBoleta")
	public String registrarBoleta() {
		try {
			//cabecera
			Boleta bol=new Boleta();
			bol.setFechaEmision(new Date());
			bol.setMonto(55555);
			//Cliente
			Cliente c=new Cliente();
			c.setCodCliente(1);
			//enviar el objeto "c" al objeto "bol"
			bol.setCliente(c);
			//Empleado
			Empleado e=new Empleado();
			e.setCodEmpleado(2);
			//enviar el objeto "e" al objeto "bol"
			bol.setEmpleado(e);
			//DETALLE
			List<MedicamentoHasBoleta> lista=
					new ArrayList<MedicamentoHasBoleta>();
			//un medicamento
				MedicamentoHasBoleta mhb=new MedicamentoHasBoleta();
					//llave
					MedicamentoHasBoletaPK pk=new MedicamentoHasBoletaPK();
					pk.setCodMedicamento(2);
				mhb.setCantidad(5);
				mhb.setPrecio(12.15);
				//setear llave
				mhb.setPk(pk);
			//enviar "mhb" al objeto "lista"	
			lista.add(mhb);
			//enviar el objeto "lista" al objeto "bol"
			bol.setListaMedicamentosXBoleta(lista);
			//
			boletaService.saveBoleta(bol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="lista1")
	public String lista1(){
		try {
			List<Boleta> lista=boletaService.
						listaBoletaXNombreCliente("Gloria");
					
			for(Boleta b:lista)
				System.out.println(b.getNumBoleta()+"-"+
									b.getCliente().getCodCliente()+"-"+
									b.getCliente().getNomCliente()+"-"+
									b.getMonto());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value="lista2")
	public String lista2(){
		try {
			List<MedicamentoHasBoleta> lista=boletaService.
						listaDetalleBoletaXNumero(2);
					
			for(MedicamentoHasBoleta b:lista)
				System.out.println(b.getBoleta().getNumBoleta()+"-"+
						b.getMedicamento().getCodMedicamento()+"-"+
						b.getMedicamento().getNomMedicamento()+"-"+
						b.getPrecio()+"-"+b.getCantidad());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}








