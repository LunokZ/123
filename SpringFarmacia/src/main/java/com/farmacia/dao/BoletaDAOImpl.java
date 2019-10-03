package com.farmacia.dao;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.farmacia.entity.Boleta;
import com.farmacia.entity.Medicamento;
import com.farmacia.entity.MedicamentoHasBoleta;
import com.farmacia.entity.MedicamentoHasBoletaPK;
@Repository
public class BoletaDAOImpl implements BoletaDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveBoleta(Boleta boleta) {
		try {
			Session session=sessionFactory.getCurrentSession();
			//grabar cabecera
			session.save(boleta); 
			//grabar detalle
			//buble
			for(MedicamentoHasBoleta mhb:boleta.getListaMedicamentosXBoleta()){
				//crear PK
				MedicamentoHasBoletaPK pk=new MedicamentoHasBoletaPK();
				pk.setNumBoleta(boleta.getNumBoleta());
				pk.setCodMedicamento(mhb.getPk().getCodMedicamento());
				//enviar pk a mhb
				mhb.setPk(pk);
				//grabar detalle
				session.save(mhb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Boleta> listaBoletaXNombreCliente(String nom) {
		List<Boleta> lista=null;
		try {
			Session session=sessionFactory.getCurrentSession();
			//select *from tb_boleta b inner join tb_cliente c 
			//on c.cod_cli=d.cod_cli where c.nom_cli='Gloria'
			String hql="select b from Boleta b where "+
					"b.cliente.nomCliente=:valor";
			Query query=session.createQuery(hql);
			query.setParameter("valor", nom);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	@Transactional(readOnly=true)
	public List<MedicamentoHasBoleta> listaDetalleBoletaXNumero(int numBoleta) {
		List<MedicamentoHasBoleta> lista=null;
		try {
			Session session=sessionFactory.getCurrentSession();
			//select *from tb_boleta b inner join tb_cliente c 
			//on c.cod_cli=d.cod_cli where c.nom_cli='Gloria'
			String hql="select mhb from MedicamentoHasBoleta mhb "+
					"where mhb.boleta.numBoleta=?1";
			Query query=session.createQuery(hql);
			query.setParameter(1, numBoleta);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
}





