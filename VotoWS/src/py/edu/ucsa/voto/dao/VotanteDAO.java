package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsVotante;





@Repository("votanteDAO")
@Transactional(readOnly = true)
public class VotanteDAO extends AbstractSpringDAO implements VotanteDAOInterface {

	public VotanteDAO() {
		claseEntidad = "UcsawsVotante";
		nombreCampoID = "idVotante";
		campoOrden = "idVotante";
	}

	@Transactional
	public void saveOrUpdate(UcsawsVotante o) {
		if (o.getIdVotante() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsVotante o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsVotante> getList() {
		return super.getList();
	}
	
			
			
	public UcsawsVotante obtenerVotante(Integer idPersona){
		List<UcsawsVotante> resultado;
		UcsawsVotante e = new UcsawsVotante();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where idPersona.idPersona = :idVotante"
				+ " and habilitado = :habilitado and sufrago = :sufrago";
		Query query = em.createQuery(hql);
		query.setParameter("idVotante", idPersona);
		query.setParameter("habilitado", Integer.parseInt("1"));
		query.setParameter("sufrago", Integer.parseInt("1"));
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsVotante) resultado.get(0);
			}
		return (UcsawsVotante) resultado.get(0);
		
		//return null;
		
	}
	
	public UcsawsVotante obtenerVotanteSinSufragar(String idPersona){
		List<UcsawsVotante> resultado;
		UcsawsVotante e = new UcsawsVotante();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where idPersona.idPersona = :idPersona"
				+ " and habilitado = :habilitado and sufrago = :sufrago";
		Query query = em.createQuery(hql);
		query.setParameter("idPersona", Integer.parseInt(idPersona));
		query.setParameter("habilitado", Integer.parseInt("1"));
		query.setParameter("sufrago", Integer.parseInt("0"));
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsVotante) resultado.get(0);
			}
		return (UcsawsVotante) resultado.get(0);
		
	}
	
	public UcsawsVotante obtenerVotanteById(Integer idVotante){
		List<UcsawsVotante> resultado;
		UcsawsVotante e = new UcsawsVotante();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where idVotante = :idVotante";
		Query query = em.createQuery(hql);
		query.setParameter("idVotante", idVotante);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsVotante) resultado.get(0);
			}
		return (UcsawsVotante) resultado.get(0);
	}

}
