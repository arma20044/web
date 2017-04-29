package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsListas;
import py.edu.ucsa.voto.entity.UcsawsUsers;

@Repository("listasDAO")
@Transactional(readOnly = true)
public class ListasDAO extends AbstractSpringDAO implements ListasDAOInterface {

	public ListasDAO() {
		claseEntidad = "UcsawsListas";
		nombreCampoID = "idLista";
		campoOrden = "idLista";
	}

	@Transactional
	public void saveOrUpdate(UcsawsListas o) {
		if (o.getIdLista() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsListas o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsListas> getList() {
		return super.getList();
	}

	public UcsawsListas obtenerLista(Integer nroLista, Integer tipoLista,
			Integer idEvento) {
		List<UcsawsListas> resultado;
		UcsawsListas e = new UcsawsListas();
		String hql;
		hql = "select obj from "
				+ claseEntidad
				+ " obj where  nroLista = :nroLista and "
				+ "ucsawsTipoLista.idTipoLista = :tipoLista and idEvento.idEvento = :idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("nroLista", nroLista);
		query.setParameter("tipoLista", tipoLista);
		query.setParameter("idEvento", idEvento);

		resultado = query.getResultList();
		if (resultado.size() == 0) {
			return e;
		} else if (resultado.size() == 1) {
			return (UcsawsListas) resultado.get(0);
		}
		return (UcsawsListas) resultado.get(0);
	}

	public UcsawsListas obtenerListaByID(Integer idLista) {
		List<UcsawsListas> resultado;
		UcsawsListas e = new UcsawsListas();
		String hql;
		hql = "select obj from "
				+ claseEntidad
				+ " obj where  id = :id";
		Query query = em.createQuery(hql);
		query.setParameter("id", idLista);


		resultado = query.getResultList();
		if (resultado.size() == 0) {
			return e;
		} else if (resultado.size() == 1) {
			return (UcsawsListas) resultado.get(0);
		}
		return (UcsawsListas) resultado.get(0);
	}
	
	public UcsawsListas obtenerLista(String codigo, Integer nroListaSeleccionada, Integer idEvento){
		
		List<UcsawsListas> resultado;
		UcsawsListas e = new UcsawsListas();
		String hql;
		hql = "select obj from "
				+ claseEntidad
				+ " obj where  nroLista = :nroListaSeleccionada and "
				+ "ucsawsTipoLista.codigo = :codigo and idEvento.idEvento = :idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("codigo", codigo);
		query.setParameter("nroListaSeleccionada", nroListaSeleccionada);
		query.setParameter("idEvento", idEvento);

		resultado = query.getResultList();
		if (resultado.size() == 0) {
			return e;
		} else if (resultado.size() == 1) {
			return (UcsawsListas) resultado.get(0);
		}
		return (UcsawsListas) resultado.get(0);
	
	}
	

}
