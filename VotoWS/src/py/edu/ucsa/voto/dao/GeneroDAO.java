package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsGenero;





@Repository("generoDAO")
@Transactional(readOnly = true)
public class GeneroDAO extends AbstractSpringDAO implements
GeneroDAOInterface {

	public GeneroDAO() {
		claseEntidad = "UcsawsGenero";
		nombreCampoID = "idGenero";
		campoOrden = "idGenero";
	}

	@Transactional
	public void saveOrUpdate(UcsawsGenero o) {
		if (o.getIdGenero() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsGenero o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsGenero> getList() {
		return super.getList();
	}
	
	
	
	public List<UcsawsGenero> obtenerGeneroById(Integer idGenero) {
	    List<UcsawsGenero>  resultado = new ArrayList<UcsawsGenero>();
		  UcsawsGenero   e= new UcsawsGenero();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idGenero =:idGenero";
		Query query = em.createQuery(hql);
		query.setParameter("idGenero", idGenero);
		resultado =  query.getResultList();
		if (resultado.size() == 0) {
		    return resultado;
		} else if (resultado.size() == 1) {
		    return   resultado;
		}
		return   resultado;
	    }
	
	public List<UcsawsGenero> obtenerGeneroByIdEvento(Integer idEvento){
	    List<UcsawsGenero>  resultado = new ArrayList<UcsawsGenero>();
		  UcsawsGenero   e= new UcsawsGenero();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado =  query.getResultList();
		if (resultado.size() == 0) {
		    return resultado;
		} else if (resultado.size() == 1) {
		    return   resultado;
		}
		return   resultado;
	}
	
	
	
	public List<UcsawsGenero> obtenerGeneroByCodigoGEneroIdEvento(String codGenero,Integer idEvento){
	    List<UcsawsGenero>  resultado = new ArrayList<UcsawsGenero>();
			  UcsawsGenero   e= new UcsawsGenero();
			String hql;
			hql = "select obj from " + claseEntidad + " obj where  idEvento =:idEvento and codigo =:codGenero";
			Query query = em.createQuery(hql);
			query.setParameter("idEvento", idEvento);
			query.setParameter("codGenero", codGenero);
			resultado =  query.getResultList();
			if (resultado.size() == 0) {
			    return resultado;
			} else if (resultado.size() == 1) {
			    return   resultado;
			}
			return   resultado;
		    }
		
	
	 


}
