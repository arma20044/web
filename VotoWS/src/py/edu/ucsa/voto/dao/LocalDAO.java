package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsDistrito;
import py.edu.ucsa.voto.entity.UcsawsLocal;
import py.edu.ucsa.voto.entity.UcsawsZona;





@Repository("localDAO")
@Transactional(readOnly = true)
public class LocalDAO extends AbstractSpringDAO implements LocalDAOInterface {

	public LocalDAO() {
		claseEntidad = "UcsawsLocal";
		nombreCampoID = "idLocal";
		campoOrden = "idLocal";
	}

	@Transactional
	public void saveOrUpdate(UcsawsLocal o) {
		if (o.getIdLocal() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsLocal o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsLocal> getList() {
		return super.getList();
	}
	
			
			
	/*public UcsawsEvento obtenerEventoByFecha(Date fecha){
		List<UcsawsEvento> resultado;
		UcsawsEvento e = new UcsawsEvento();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  :fecha  between fchDesde and fchHasta";
		Query query = em.createQuery(hql);
		query.setParameter("fecha", fecha);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsEvento) resultado.get(0);
			}
		return (UcsawsEvento) resultado.get(0);
		
		//return null;
		
	}
	*/
	public UcsawsLocal obtenerLocalById(Integer idLocal){
		List<UcsawsLocal> resultado;
		UcsawsLocal e = new UcsawsLocal();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idLocal";
		Query query = em.createQuery(hql);
		query.setParameter("idLocal", idLocal);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsLocal) resultado.get(0);
			}
		return (UcsawsLocal) resultado.get(0);
	}
	
	public List<UcsawsLocal> obtenerLocalByIdEvento(Integer idEvento){
		List<UcsawsLocal> resultado;
		UcsawsLocal e = new UcsawsLocal();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsLocal>();
		}
		else
		 
		    return resultado;
			 
		 
	}
	
	public List<UcsawsLocal> obtenerLocalByIdZona(Integer idZona){
	    List<UcsawsLocal> resultado;
	    UcsawsLocal e = new UcsawsLocal();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  ucsawsZona.idZona =:idZona";
		Query query = em.createQuery(hql);
		query.setParameter("idZona", idZona);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsLocal>();
		}
		else
		 
		    return resultado;
			 
	}

}
