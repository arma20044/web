package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsVotos;





@Repository("votoDAO")
@Transactional(readOnly = true)
public class VotoDAO extends AbstractSpringDAO implements VotoDAOInterface {

	public VotoDAO() {
		claseEntidad = "UcsawsVotos";
		nombreCampoID = "idVoto";
		campoOrden = "idVoto";
	}

	@Transactional
	public void saveOrUpdate(UcsawsVotos o) {
		if (o.getIdVoto() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsVotos o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsVotos> getList() {
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
		
	}*/

}
