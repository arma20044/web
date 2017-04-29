package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsTipoLista;
import py.edu.ucsa.voto.entity.UcsawsUsers;

@Repository("tipoListasDAO")
@Transactional(readOnly = true)
public class TipoListasDAO extends AbstractSpringDAO implements
		TipoListasDAOInterface {

	public TipoListasDAO() {
		claseEntidad = "UcsawsTipoLista";
		nombreCampoID = "idTipoLista";
		campoOrden = "idTipoLista";
	}

	@Transactional
	public void saveOrUpdate(UcsawsTipoLista o) {
		if (o.getIdTipoLista() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsTipoLista o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsTipoLista> getList() {
		return super.getList();
	}

	public UcsawsTipoLista obtenerTipoLista(Integer nroLista,
			Integer tipoLista, Integer idEvento)  {
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

	public UcsawsTipoLista obtenerTipoListaById(Integer idTipoLista) {
		return null;

	}

	public UcsawsTipoLista obtenerTipoListaByCodigo(String codigo, Integer idEvento) {
		List<UcsawsTipoLista> resultado;
		UcsawsTipoLista e = new UcsawsTipoLista();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  codigo = :codigo and idEvento = :idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("codigo", codigo);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size() == 0) {
			return e;
		} else if (resultado.size() == 1) {
			return (UcsawsTipoLista) resultado.get(0);
		}
		return (UcsawsTipoLista) resultado.get(0);
	}




}
