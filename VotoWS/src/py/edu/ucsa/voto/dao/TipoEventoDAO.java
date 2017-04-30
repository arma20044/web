package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsTipoEvento;





@Repository("tipoEventoDAO")
@Transactional(readOnly = true)
public class TipoEventoDAO extends AbstractSpringDAO implements TipoEventoDAOInterface {

	public TipoEventoDAO() {
		claseEntidad = "UcsawsTipoEvento";
		nombreCampoID = "idTipoEvento";
		campoOrden = "idTipoEvento";
	}

	@Transactional
	public void saveOrUpdate(UcsawsTipoEvento o) {
		if (o.getIdTipoEvento() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsTipoEvento o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsTipoEvento> getList() {
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
	public UcsawsTipoEvento obtenerTipoEventoById(Integer idETipovento){
		List<UcsawsTipoEvento> resultado;
		UcsawsTipoEvento e = new UcsawsTipoEvento();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idTipoEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idTipoEvento", idETipovento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsTipoEvento) resultado.get(0);
			}
		return (UcsawsTipoEvento) resultado.get(0);
	}

}
