package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsPais;

@Repository("paisDAO")
@Transactional(readOnly = true)
public class PaisDAO extends AbstractSpringDAO implements PaisDAOInterface {

    public PaisDAO() {
	claseEntidad = "UcsawsPais";
	nombreCampoID = "idPais";
	campoOrden = "idPais";
    }

    @Transactional
    public void saveOrUpdate(UcsawsPais o) {
	if (o.getIdEvento() == null)
	    super.save(o);
	else
	    super.update(o);
    }

    @Transactional
    public void delete(UcsawsPais o) {
	super.delete(o);
    }

    @Transactional
    public List<UcsawsPais> getList() {
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
    public List<UcsawsPais> obtenerPaisByEvento(Integer idEvento){
	
	List<UcsawsPais> resultado;
	UcsawsPais e = new UcsawsPais();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  idEvento.idEvento =:idEvento";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new ArrayList<UcsawsPais>();
	} else if (resultado.size() == 1) {
	    return  resultado ;
	}
	return resultado ;
	 
	
    }
    
    public UcsawsPais obtenerPaisByNombreYEvento(String codigo, Integer idEvento, String nombre){
	 List<UcsawsPais> resultado;
	UcsawsPais e = new UcsawsPais();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  (idEvento.idEvento =:idEvento and codigo =:codigo) or (idEvento.idEvento =:idEvento and nombre =:nombre) ";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	query.setParameter("codigo", codigo);
	query.setParameter("nombre", nombre);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new  UcsawsPais();
	} else if (resultado.size() == 1) {
	    return  resultado.get(0) ;
	}
	return resultado.get(0)  ;
    }
    
    public UcsawsPais obtenerPaisById(Integer idPais){
	
	List<UcsawsPais> resultado;
	 
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  idPais =:idPais";
	Query query = em.createQuery(hql);
	query.setParameter("idPais", idPais);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new ArrayList<UcsawsPais>().get(0);
	} else if (resultado.size() == 1) {
	    return  resultado.get(0) ;
	}
	return resultado.get(0) ;
    }
    
    public  UcsawsPais  obtenerPaisByIdYEvento(Integer idPais, Integer idEvento){
	List<UcsawsPais> resultado;
	 
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  idPais =:idPais and idEvento.idEvento =:idEvento";
	Query query = em.createQuery(hql);
	query.setParameter("idPais", idPais);
	query.setParameter("idEvento", idEvento);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new ArrayList<UcsawsPais>().get(0);
	} else if (resultado.size() == 1) {
	    return  resultado.get(0) ;
	}
	return resultado.get(0) ;
    }
    
    public List<UcsawsPais> obtenerPaisByEventoFueraNacionalidad(Integer idEvento){
	
	List<UcsawsPais> resultado;
	UcsawsPais e = new UcsawsPais();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  idEvento.idEvento =:idEvento and obj.idPais not in (select obj1.ucsawsPais.idPais from UcsawsNacionalidad obj1 where idEvento =:idEvento)";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new ArrayList<UcsawsPais>();
	} else if (resultado.size() == 1) {
	    return  resultado ;
	}
	return resultado ;
	 
	
    }
    

}
