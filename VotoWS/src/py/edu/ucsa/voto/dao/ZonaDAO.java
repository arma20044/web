package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsDistrito;
import py.edu.ucsa.voto.entity.UcsawsZona;





@Repository("zonaDAO")
@Transactional(readOnly = true)
public class ZonaDAO extends AbstractSpringDAO implements ZonaDAOInterface {

	public ZonaDAO() {
		claseEntidad = "UcsawsZona";
		nombreCampoID = "idZona";
		campoOrden = "idZona";
	}

	@Transactional
	public void saveOrUpdate(UcsawsZona o) {
		if (o.getIdZona() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsZona o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsZona> getList() {
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
	public UcsawsZona obtenerZonaById(Integer idZona){
		List<UcsawsZona> resultado;
		UcsawsZona e = new UcsawsZona();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idZona";
		Query query = em.createQuery(hql);
		query.setParameter("idZona", idZona);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsZona) resultado.get(0);
			}
		return (UcsawsZona) resultado.get(0);
	}
	
	public List<UcsawsZona> obtenerZonaByIdEvento(Integer idEvento){
		List<UcsawsZona> resultado;
		UcsawsDistrito e = new UcsawsDistrito();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsZona>();
		}
		else
		 
		    return resultado;
			 
		 
	}
	
	public List<UcsawsZona> obtenerZonaByIdDistrito(Integer IdDistrito){
	    List<UcsawsZona> resultado;
		UcsawsDistrito e = new UcsawsDistrito();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  ucsawsDistrito.idDistrito =:IdDistrito";
		Query query = em.createQuery(hql);
		query.setParameter("IdDistrito", IdDistrito);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsZona>();
		}
		else
		 
		    return resultado;
			 
	}

}
