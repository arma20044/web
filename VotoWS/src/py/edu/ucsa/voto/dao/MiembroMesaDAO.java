package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 

import py.edu.ucsa.voto.entity.UcsawsMiembroMesa;

 

@Repository("miembroMesaDAO")
@Transactional(readOnly = true)
public class MiembroMesaDAO extends AbstractSpringDAO implements MiembroMesaDAOInterface {

	public MiembroMesaDAO() {
		claseEntidad = "UcsawsMiembroMesa";
		nombreCampoID = "idMiembroMesa";
		campoOrden = "idMiembroMesa";
	}

	@Transactional
	public void saveOrUpdate(UcsawsMiembroMesa o) {
		if (o.getIdMiembroMesa() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsMiembroMesa o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsMiembroMesa> getList() {
		return super.getList();
	}

	public UcsawsMiembroMesa obtenerMiembroMesa(Integer codigoMiembroMesa, Integer persona,
	      Integer idEvento)  {
		return null;
		/*
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
	}



 
	
	public UcsawsMiembroMesa obtenerMiembroMesaById(Integer idMiembroMesa){
		List<UcsawsMiembroMesa> resultado;
		UcsawsMiembroMesa e = new UcsawsMiembroMesa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idMiembroMesa";
		Query query = em.createQuery(hql);
		query.setParameter("idMiembroMesa", idMiembroMesa);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsMiembroMesa) resultado.get(0);
			}
		return (UcsawsMiembroMesa) resultado.get(0);
	}
	
	public List<UcsawsMiembroMesa> obtenerMiembroMesaByIdEvento(Integer idEvento){
		List<UcsawsMiembroMesa> resultado;
		UcsawsMiembroMesa e = new UcsawsMiembroMesa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsMiembroMesa>();
		}
		else
		 
		    return resultado;
			 
		 
	}




}
