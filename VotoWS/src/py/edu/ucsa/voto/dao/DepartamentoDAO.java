package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsDepartamento;
import py.edu.ucsa.voto.entity.UcsawsEvento;





@Repository("departamentoDAO")
@Transactional(readOnly = true)
public class DepartamentoDAO extends AbstractSpringDAO implements DepartamentoDAOInterface {

	public DepartamentoDAO() {
		claseEntidad = "UcsawsDepartamento";
		nombreCampoID = "idDepartamento";
		campoOrden = "idDepartamento";
	}

	@Transactional
	public void saveOrUpdate(UcsawsDepartamento o) {
		if (o.getIdDepartamento() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsDepartamento o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsDepartamento> getList() {
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
	public UcsawsDepartamento obtenerDepartamentoById(Integer idEDepartamento){
		List<UcsawsDepartamento> resultado;
		UcsawsDepartamento e = new UcsawsDepartamento();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idEDepartamento";
		Query query = em.createQuery(hql);
		query.setParameter("idEDepartamento", idEDepartamento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsDepartamento) resultado.get(0);
			}
		return (UcsawsDepartamento) resultado.get(0);
	}
	
	public List<UcsawsDepartamento> obtenerDepartamentoByIdEvento(Integer idEvento){
		List<UcsawsDepartamento> resultado;
		UcsawsDepartamento e = new UcsawsDepartamento();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsDepartamento>();
		}
		else
		 
		    return resultado;
			 
		 
	}

}
