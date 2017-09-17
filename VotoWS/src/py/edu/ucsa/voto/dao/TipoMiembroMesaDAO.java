package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
import py.edu.ucsa.voto.entity.UcsawsTipoMiembroMesa;

 

@Repository("tipoMiembroMesaDAO")
@Transactional(readOnly = true)
public class TipoMiembroMesaDAO extends AbstractSpringDAO implements TipoMiembroMesaDAOInterface {

	public TipoMiembroMesaDAO() {
		claseEntidad = "UcsawsTipoMiembroMesa";
		nombreCampoID = "idTipoMiembroMesa";
		campoOrden = "idTipoMiembroMesa";
	}

	@Transactional
	public void saveOrUpdate(UcsawsTipoMiembroMesa o) {
		if (o.getIdTipoMiembroMesa() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsTipoMiembroMesa o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsTipoMiembroMesa> getList() {
		return super.getList();
	}

	public UcsawsTipoMiembroMesa obtenerTipoMiembroMesa(Integer codigoActa,
			Integer tipoActa, Integer idEvento)  {
		return null;
		/*
		 * List<UcsawsListas> resultado; UcsawsListas e = new UcsawsListas();
		 * String hql; hql = "select obj from " + claseEntidad +
		 * " obj where  id = :id"; Query query = em.createQuery(hql);
		 * query.setParameter("id", idLista);
		 * 
		 * 
		 * resultado = query.getResultList(); if (resultado.size() == 0) {
		 * return e; } else if (resultado.size() == 1) { return (UcsawsListas)
		 * resultado.get(0); } return (UcsawsListas) resultado.get(0);
		 */
	}



	public UcsawsTipoMiembroMesa obtenerTipoMiembroMesaByCodigo(String codigo, Integer idEvento) {
		List<UcsawsTipoMiembroMesa> resultado;
		UcsawsTipoMiembroMesa e = new UcsawsTipoMiembroMesa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  codigo = :codigo and idEvento = :idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("codigo", codigo);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size() == 0) {
			return e;
		} else if (resultado.size() == 1) {
			return (UcsawsTipoMiembroMesa) resultado.get(0);
		}
		return (UcsawsTipoMiembroMesa) resultado.get(0);
	}
	
	public UcsawsTipoMiembroMesa obtenerTipoMiembroMesaById(Integer idTipoMiembroMesa){
		List<UcsawsTipoMiembroMesa> resultado;
		UcsawsTipoMiembroMesa e = new UcsawsTipoMiembroMesa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  id =:idTipoMiembroMesa";
		Query query = em.createQuery(hql);
		query.setParameter("idTipoMiembroMesa", idTipoMiembroMesa);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsTipoMiembroMesa) resultado.get(0);
			}
		return (UcsawsTipoMiembroMesa) resultado.get(0);
	}
	
	public List<UcsawsTipoMiembroMesa> obtenerTipoMiembroMesaByIdEvento(Integer idEvento){
		List<UcsawsTipoMiembroMesa> resultado;
		UcsawsTipoMiembroMesa e = new UcsawsTipoMiembroMesa();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
		Query query = em.createQuery(hql);
		query.setParameter("idEvento", idEvento);
		resultado = query.getResultList();
		if (resultado.size()==0){
			return new ArrayList<UcsawsTipoMiembroMesa>();
		}
		else
		 
		    return resultado;
			 
		 
	}




}
