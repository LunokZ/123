package com.farmacia.dao;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.farmacia.entity.Laboratorio;
@Repository
public class LaboratorioDAOImpl implements LaboratorioDAO{
	//inyectar la conexión con BD
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	@Transactional
	public void insertLaboratorio(Laboratorio lab) {
		//Abrir una sesión de la conex.
		Session session=sessionFactory.getCurrentSession();
		try {
			session.save(lab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional
	public void updateLaboratorio(Laboratorio lab) {
		//Abrir una sesión de la conex.
		Session session=sessionFactory.getCurrentSession();
		try {
			session.update(lab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional
	public void deleteLaboratorio(int cod) {
		//Abrir una sesión de la conex.
		Session session=sessionFactory.getCurrentSession();
		try {
			Laboratorio lab;
			lab=session.get(Laboratorio.class, cod);
			session.delete(lab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional(readOnly=true)
	public Laboratorio findLaboratorio(int cod) {
		//Abrir una sesión de la conex.
		Session session=sessionFactory.getCurrentSession();
		Laboratorio lab=null;
		try {
			lab=session.get(Laboratorio.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lab;
	}
	@Override
	@Transactional(readOnly=true)
	public List<Laboratorio> listLaboratorios() {
		//Abrir una sesión de la conex.
		Session session=sessionFactory.getCurrentSession();
		List<Laboratorio> lista=null;
		try {
			//HQL
			String sql="select lab from Laboratorio lab";
			Query query=session.createQuery(sql);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}






