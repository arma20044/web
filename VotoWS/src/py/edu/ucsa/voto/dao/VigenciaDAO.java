package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsPais;
import py.edu.ucsa.voto.entity.UcsawsVigenciaHorarioXPais;

 





@Repository("vigenciaDAO")
@Transactional(readOnly = true)
public class VigenciaDAO extends AbstractSpringDAO implements VigenciaDAOInterface {

	public VigenciaDAO() {
		claseEntidad = "UcsawsVigenciaHorarioXPais";
		nombreCampoID = "idVigencia";
		campoOrden = "idVigencia";
	}

	@Transactional
	public void saveOrUpdate(UcsawsVigenciaHorarioXPais o) {
		if (o.getIdVigencia() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsVigenciaHorarioXPais o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsVigenciaHorarioXPais> getList() {
		return super.getList();
	}
	
			
			
	public UcsawsVigenciaHorarioXPais obtenerVigenciaById(Integer idVigencia){
		List<UcsawsVigenciaHorarioXPais> resultado;
		UcsawsVigenciaHorarioXPais e = new UcsawsVigenciaHorarioXPais();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where id = :id";
		Query query = em.createQuery(hql);
		query.setParameter("id", idVigencia);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsVigenciaHorarioXPais) resultado.get(0);
			}
		return (UcsawsVigenciaHorarioXPais) resultado.get(0);
		
		//return null;
		
	}
	
	public List<UcsawsVigenciaHorarioXPais> obtenerVigenciaByPais(UcsawsPais pais){
	    List<UcsawsVigenciaHorarioXPais> resultado;
	    UcsawsVigenciaHorarioXPais e = new UcsawsVigenciaHorarioXPais();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idPais =:pais";
		Query query = em.createQuery(hql);
		query.setParameter("pais", pais);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsVigenciaHorarioXPais>();
		}
		else
		 
		    return resultado;
			 
	}
	
	
	public List<UcsawsVigenciaHorarioXPais> obtenerVigenciaByIdEvento(UcsawsEvento evento){
		List<UcsawsVigenciaHorarioXPais> resultado;
		UcsawsVigenciaHorarioXPais e = new UcsawsVigenciaHorarioXPais();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", evento.getIdEvento());
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsVigenciaHorarioXPais>();
		}
		else
		 
		    return resultado;
			 
		 
	}
	


}
