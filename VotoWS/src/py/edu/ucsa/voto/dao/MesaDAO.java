package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsLocal;
import py.edu.ucsa.voto.entity.UcsawsMesa;





@Repository("mesaDAO")
@Transactional(readOnly = true)
public class MesaDAO extends AbstractSpringDAO implements MesaDAOInterface {

	public MesaDAO() {
		claseEntidad = "UcsawsMesa";
		nombreCampoID = "idMesa";
		campoOrden = "idMesa";
	}

	@Transactional
	public void saveOrUpdate(UcsawsMesa o) {
		if (o.getIdMesa() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsMesa o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsMesa> getList() {
		return super.getList();
	}
	
			
			
	public UcsawsMesa obtenerMesaById(Integer idMesa){
		List<UcsawsMesa> resultado;
		UcsawsMesa e = new UcsawsMesa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where id = :id";
		Query query = em.createQuery(hql);
		query.setParameter("id", idMesa);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsMesa) resultado.get(0);
			}
		return (UcsawsMesa) resultado.get(0);
		
		//return null;
		
	}
	
	public List<UcsawsMesa> obtenerMesaByIdLocal(Integer idLocal){
	    List<UcsawsMesa> resultado;
	    UcsawsLocal e = new UcsawsLocal();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  ucsawsLocal.idLocal =:idLocal";
		Query query = em.createQuery(hql);
		query.setParameter("idLocal", idLocal);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsMesa>();
		}
		else
		 
		    return resultado;
			 
	}
	
	
	public List<UcsawsMesa> obtenerMesaByIdEvento(Integer idEvento){
		List<UcsawsMesa> resultado;
		UcsawsLocal e = new UcsawsLocal();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsMesa>();
		}
		else
		 
		    return resultado;
			 
		 
	}
	


}
