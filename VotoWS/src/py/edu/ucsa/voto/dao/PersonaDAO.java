package py.edu.ucsa.voto.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsPersona;

@Repository("personaDAO")
@Transactional(readOnly = true)
public class PersonaDAO extends AbstractSpringDAO implements PersonaDAOInterface {

    public PersonaDAO() {
	claseEntidad = "UcsawsPersona";
	nombreCampoID = "idPersona";
	campoOrden = "idPersona";
    }

    @Transactional
    public void saveOrUpdate(UcsawsPersona o) {
	if (o.getIdEvento() == null)
	    super.save(o);
	else
	    super.update(o);
    }

    @Transactional
    public void delete(UcsawsPersona o) {
	super.delete(o);
    }

    @Transactional
    public List<UcsawsPersona> getList() {
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
    public List<UcsawsPersona> obtenerPersonaByEvento(Integer idEvento){
	
	List<UcsawsPersona> resultado;
	UcsawsPersona e = new UcsawsPersona();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  idEvento.idEvento =:idEvento";
	Query query = em.createQuery(hql);
	query.setParameter("idEvento", idEvento);
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new ArrayList<UcsawsPersona>();
	} else if (resultado.size() == 1) {
	    return  resultado ;
	}
	return resultado ;
	 
	
    }
    
    public List<UcsawsPersona> obtenerPersonaByCedula(Integer cedula){
	
	List<UcsawsPersona> resultado;
	UcsawsPersona e = new UcsawsPersona();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  ci =:ci";
	Query query = em.createQuery(hql);
	query.setParameter("ci",new BigDecimal(cedula));
	resultado = query.getResultList();
	if (resultado.size() == 0) {
	    return new ArrayList<UcsawsPersona>();
	} else if (resultado.size() == 1) {
	    return  resultado ;
	}
	return resultado ;
	 
	
    }
    
    public UcsawsPersona obtenerPersonaByIdPersona(Integer idPersona){
	
	UcsawsPersona resultado;
	UcsawsPersona e = new UcsawsPersona();
	String hql;
	hql = "select obj from " + claseEntidad
		+ " obj where  id =:idPersona";
	Query query = em.createQuery(hql);
	query.setParameter("idPersona",idPersona);
	resultado = (UcsawsPersona) query.getSingleResult();
	if (resultado.getIdPersona() == null) {
	    return new  UcsawsPersona ();
	} else   {
	    return  resultado ;
	}
	
	
    }

}
