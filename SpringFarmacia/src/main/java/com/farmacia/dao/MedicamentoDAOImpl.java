package com.farmacia.dao;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.farmacia.entity.Medicamento;
@Repository
public class MedicamentoDAOImpl implements MedicamentoDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertMedicamento(Medicamento med) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.save(med);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@Override
	@Transactional
	public void updateMedicamento(Medicamento med) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.update(med);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional
	public void deleteMedicamento(int cod) {
		Session session=sessionFactory.getCurrentSession();
		try {
			Medicamento med=session.find(
						Medicamento.class, cod);
			session.delete(med);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional(readOnly=true)
	public Medicamento findMedicamento(int cod) {
		Medicamento med=null;
		Session session=sessionFactory.getCurrentSession();
		try {
			med=session.find(Medicamento.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return med;
	}
	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> listMedicamentos() {
		List<Medicamento> lista=null;
		Session session=sessionFactory.getCurrentSession();
		try {
			String sql;
			sql="select med from Medicamento med";
			Query query=session.createQuery(sql);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> listMedicamentosXLaboratorio(int codLab) {
		List<Medicamento> lista=null;
		try {
			Session session=sessionFactory.getCurrentSession();
			//select *from tb_medicamento where cod_lab=1
			String hql="select m from Medicamento m where "+
					"m.laboratorio.codLaboratorio=:valor";
			Query query=session.createQuery(hql);
			query.setParameter("valor", codLab);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> listMedicamentosXNombre(String nom) {
		List<Medicamento> lista=null;
		try {
			Session session=sessionFactory.getCurrentSession();
			//select *from tb_medicamento where nom_med like 'a%'
			String hql="select m from Medicamento m where "+
					"m.nomMedicamento like CONCAT(?1,'%')";
			Query query=session.createQuery(hql);
			query.setParameter(1, nom);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	@Override
	@Transactional
	public void actualizarPrecio(double porcentaje) {
		Session session=sessionFactory.getCurrentSession();
		try {
			//update tb_medicamento set pre_med=pre_med+pre_med*0.15
			String hql="update Medicamento m set m.precio="+
						"m.precio+m.precio*?1";
			Query query=session.createQuery(hql);
			query.setParameter(1, porcentaje);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	@Transactional
	public int actualizarPrecio(int codLab, int cantidad) {
		int salida=-1;
		Session session=sessionFactory.getCurrentSession();
		try {
			String hql="update Medicamento m set m.stock="+
				"m.stock-?1 where m.laboratorio.codLaboratorio=?2";
			Query query=session.createQuery(hql);
			query.setParameter(1, cantidad);
			query.setParameter(2, codLab);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

}












