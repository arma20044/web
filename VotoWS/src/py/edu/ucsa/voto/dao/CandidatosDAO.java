package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsCandidatos;


@Repository("candidatosDAO")
@Transactional(readOnly = true)
public class CandidatosDAO extends AbstractSpringDAO implements CandidatosDAOInterface {

    public CandidatosDAO() {
	claseEntidad = "UcsawsCandidatos";
	nombreCampoID = "idCandidatos";
	campoOrden = "idCandidatos";
    }

    @Transactional
    public void saveOrUpdate(UcsawsCandidatos o) {
	if (o.getIdCandidatos() == null)
	    super.save(o);
	else
	    super.update(o);
    }

    @Transactional
    public void delete(UcsawsCandidatos o) {
	super.delete(o);
    }

    @Transactional
    public List<UcsawsCandidatos> getList() {
	return super.getList();
    }

   /* public UcsawsEvento obtenerEventoByFecha(Date fecha) {
	List<UcsawsEvento> resultado;
	UcsawsEvento e = new UcsawsEvento();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  :fecha  between fchDesde and fchHasta";
	Query query = em.createQuery(hql);
	query.setParameter("fecha", fecha);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return e;
	} else if (resultado.size() == 1) {
	    return (UcsawsEvento) resultado.get(0);
	}
	return (UcsawsEvento) resultado.get(0);

	// return null;

    }

    public UcsawsEvento obtenerEventoById(Integer idEvento) {
	List<UcsawsEvento> resultado;
	UcsawsEvento e = new UcsawsEvento();
	String hql;
	hql = "select obj from " + claseEntidad + " obj where  id =:idEvento";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return e;
	} else if (resultado.size() == 1) {
	    return (UcsawsEvento) resultado.get(0);
	}
	return (UcsawsEvento) resultado.get(0);
    }

    public UcsawsEvento obtenerEventoByCodigo(String codigoEvento) {
	List<UcsawsEvento> resultado;
	UcsawsEvento e = new UcsawsEvento();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  nroEvento =:codEvento";
	Query query = em.createQuery(hql);
	query.setParameter("codEvento", codigoEvento);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return e;
	} else if (resultado.size() == 1) {
	    return (UcsawsEvento) resultado.get(0);
	}
	return (UcsawsEvento) resultado.get(0);
    }

    public UcsawsEvento obtenerEventoByRangoFechaTipoEvento(Generic g) {
	List<UcsawsEvento> resultado;
	UcsawsEvento e = new UcsawsEvento();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where :desde  between fchDesde  and fchHasta "
		+ " and :hasta  between fchDesde  and fchHasta "
		+ " and ucsawsTipoEvento.idTipoEvento = :idTipoEvento";

	Query query = em.createQuery(hql);
	query.setParameter("desde", g.getDesde());
	query.setParameter("hasta", g.getHasta());
	query.setParameter("idTipoEvento", g.getId());
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return e;
	} else if (resultado.size() == 1) {
	    return (UcsawsEvento) resultado.get(0);
	}
	return (UcsawsEvento) resultado.get(0);

	// return null;

    }

    // ("select id_evento, descripcion "
    // + " from ucsaws_evento where (  fch_desde   <= now() "
    // + " and fch_hasta  >= now() and id_evento = " + idEvento + ")"
    // + " or ( fch_hasta  <  now() and id_evento = " + idEvento + " )"
    // );

    public UcsawsEvento obtenerEventoByRangoFechaEvento(Generic g) {
	List<UcsawsEvento> resultado;
	UcsawsEvento e = new UcsawsEvento();
	String hql;
	hql = "select obj from "
		+ claseEntidad
		+ " obj where ( fchDesde <= :hoy  and fchHasta >= :hoy and idEvento =:idEvento )"
		+ " or ( fchHasta < :hoy and idEvento = :idEvento)";

	Query query = em.createQuery(hql);
	// query.setParameter("desde", g.getDesde());
	// query.setParameter("hasta", g.getHasta());
	query.setParameter("idEvento", g.getId());
	query.setParameter("hoy", new Date());
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return e;
	} else if (resultado.size() == 1) {
	    return (UcsawsEvento) resultado.get(0);
	}
	return (UcsawsEvento) resultado.get(0);

	// return null;

    }
    */
    public UcsawsCandidatos  obtenerCandidatosByID(Integer idCandidato){
	
	List<UcsawsCandidatos> resultado;
	UcsawsCandidatos e = new UcsawsCandidatos();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  id =:idCandidato";
	Query query = em.createQuery(hql);
	query.setParameter("idCandidato", idCandidato);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new  UcsawsCandidatos();
	} else if (resultado.size() == 1) {
	    return  resultado.get(0) ;
	}
	return resultado.get(0)  ;
    }
    
    
    public List<UcsawsCandidatos> obtenerCandidatosByEvento(Integer idEvento){
	
	List<UcsawsCandidatos> resultado;
	UcsawsCandidatos e = new UcsawsCandidatos();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  idEvento.idEvento =:idEvento";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new ArrayList<UcsawsCandidatos>();
	} else if (resultado.size() == 1) {
	    return  resultado ;
	}
	return resultado ;
	 
	
    }
    
 /*   public UcsawsNacionalidad obtenerNacionalidadByCodigoYNombre(String codigo, String nombre, Integer idEvento){
	
	
	
	
	 List<UcsawsNacionalidad>  resultado = new ArrayList<UcsawsNacionalidad>(); 
	 
	String hql;
	hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento and codNacionalidad =:codigo"
		+ " and descNacionalidad =:nombre";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	query.setParameter("codigo", codigo);
	query.setParameter("nombre", nombre);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new UcsawsNacionalidad();
	} else if (resultado.size() == 1) {
	    return  resultado.get(0) ;
	}
	return resultado.get(0) ;
	
    }*/
    
  /*  public UcsawsNacionalidad obtenerNacionalidadByPaisyEvento(Integer idPais, Integer idEvento){
	
	
	
	
	 List<UcsawsNacionalidad>  resultado = new ArrayList<UcsawsNacionalidad>(); 
	 
	String hql;
	hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento and ucsawsPais.idPais =:idPais";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	query.setParameter("idPais", idPais);
 	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new UcsawsNacionalidad();
	} else if (resultado.size() == 1) {
	    return  resultado.get(0) ;
	}
	return resultado.get(0) ;
	
    }*/

    
    
   /* public UcsawsNacionalidad obtenerNacionalidadByPais (Integer idPais ){
	
	
	 List<UcsawsNacionalidad>  resultado = new ArrayList<UcsawsNacionalidad>(); 
	 
	String hql;
	hql = "select obj from " + claseEntidad + " obj where  ucsawsPais.idPais =:idPais";
	Query query = em.createQuery(hql);
 	query.setParameter("idPais", idPais);
 	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new UcsawsNacionalidad();
	} else if (resultado.size() == 1) {
	    return  resultado.get(0) ;
	}
	return resultado.get(0) ;
	
    }*/
}
