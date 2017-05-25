package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsDistrito;





@Repository("distritoDAO")
@Transactional(readOnly = true)
public class DistritoDAO extends AbstractSpringDAO implements DistritoDAOInterface {

	public DistritoDAO() {
		claseEntidad = "UcsawsDistrito";
		nombreCampoID = "idDistrito";
		campoOrden = "idDistrito";
	}

	@Transactional
	public void saveOrUpdate(UcsawsDistrito o) {
		if (o.getIdDistrito() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsDistrito o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsDistrito> getList() {
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
	public UcsawsDistrito obtenerDistritoById(Integer idDistrito){
		List<UcsawsDistrito> resultado;
		UcsawsDistrito e = new UcsawsDistrito();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idDistrito";
		Query query = em.createQuery(hql);
		query.setParameter("idDistrito", idDistrito);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsDistrito) resultado.get(0);
			}
		return (UcsawsDistrito) resultado.get(0);
	}
	
	public List<UcsawsDistrito> obtenerDistritoByIdEvento(Integer idEvento){
		List<UcsawsDistrito> resultado;
		UcsawsDistrito e = new UcsawsDistrito();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsDistrito>();
		}
		else
		 
		    return resultado;
			 
		 
	}

}
