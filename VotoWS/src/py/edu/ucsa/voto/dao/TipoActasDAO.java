package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsTipoActa;

 

@Repository("tipoActasDAO")
@Transactional(readOnly = true)
public class TipoActasDAO extends AbstractSpringDAO implements TipoActasDAOInterface {

	public TipoActasDAO() {
		claseEntidad = "UcsawsTipoActa";
		nombreCampoID = "idTipoActa";
		campoOrden = "idTipoActa";
	}

	@Transactional
	public void saveOrUpdate(UcsawsTipoActa o) {
		if (o.getIdTipoActa() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsTipoActa o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsTipoActa> getList() {
		return super.getList();
	}

	public UcsawsTipoActa obtenerTipoActa(Integer codigoActa,
			Integer tipoActa, Integer idEvento)  {
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



	public UcsawsTipoActa obtenerTipoActaByCodigo(String codigo, Integer idEvento) {
		List<UcsawsTipoActa> resultado;
		UcsawsTipoActa e = new UcsawsTipoActa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  codigoActa = :codigo and idEvento = :idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("codigo", codigo);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size() == 0) {
			return e;
		} else if (resultado.size() == 1) {
			return (UcsawsTipoActa) resultado.get(0);
		}
		return (UcsawsTipoActa) resultado.get(0);
	}
	
	public UcsawsTipoActa obtenerTipoActaById(Integer idTipoActa){
		List<UcsawsTipoActa> resultado;
		UcsawsTipoActa e = new UcsawsTipoActa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idTipoActa";
		Query query = em.createQuery(hql);
		query.setParameter("idTipoActa", idTipoActa);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsTipoActa) resultado.get(0);
			}
		return (UcsawsTipoActa) resultado.get(0);
	}
	
	public List<UcsawsTipoActa> obtenerTipoActaByIdEvento(Integer idEvento){
		List<UcsawsTipoActa> resultado;
		UcsawsTipoActa e = new UcsawsTipoActa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsTipoActa>();
		}
		else
		 
		    return resultado;
			 
		 
	}




}
