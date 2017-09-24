package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 


import py.edu.ucsa.voto.entity.UcsawsActas;
import py.edu.ucsa.voto.entity.UcsawsMiembroMesa;

 

@Repository("actaMesaDAO")
@Transactional(readOnly = true)
public class ActaDAO extends AbstractSpringDAO implements ActaDAOInterface {

	public ActaDAO() {
		claseEntidad = "UcsawsActas";
		nombreCampoID = "idActa";
		campoOrden = "idActa";
	}

	@Transactional
	public void saveOrUpdate(UcsawsActas o) {
		if (o.getIdActa() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsActas o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsActas> getList() {
		return super.getList();
	}

	/*
	 public UcsawsMiembroMesa obtenerMiembroMesa(Integer codigoMiembroMesa, Integer persona,
	      Integer idEvento)  {
		return null;
		 
		 * List<UcsawsListas> resultado; UcsawsListas e = new UcsawsListas();
		 * String hql; hql = "select obj from " + claseEntidad +
		 * " obj where  id = :id"; Query query = em.createQuery(hql);
		 * query.setParameter("id", idLista);
		 * 
		 * 
		 * resultado = query.getResultList(); if (resultado.size() == 0) {
		 * return e; } else if (resultado.size() == 1) { return (UcsawsListas)
		 * resultado.get(0); } return (UcsawsListas) resultado.get(0);
		 */
	//}
 



 
	
	public UcsawsActas obtenerActaById(Integer idActa){
		List<UcsawsActas> resultado;
		UcsawsActas e = new UcsawsActas();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idActa";
		Query query = em.createQuery(hql);
		query.setParameter("idActa", idActa);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsActas) resultado.get(0);
			}
		return (UcsawsActas) resultado.get(0);
	}
	
	public List<UcsawsActas> obtenerActaByIdEvento(Integer idEvento){
		List<UcsawsActas> resultado;
		UcsawsActas e = new UcsawsActas();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsActas>();
		}
		else
		 
		    return resultado;
			 
		 
	}




}
