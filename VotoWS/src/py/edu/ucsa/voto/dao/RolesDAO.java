package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsRoles;



@Repository("rolesDAO")
@Transactional(readOnly = true)
public class RolesDAO extends AbstractSpringDAO implements
RolesDAOInterface {

	public RolesDAO() {
		claseEntidad = "UcsawsRoles";
		nombreCampoID = "idRol";
		campoOrden = "idRol";
	}

	@Transactional
	public void saveOrUpdate(UcsawsRoles o) {
		if (o.getIdRol() != 0)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(UcsawsRoles o) {
		super.delete(o);
	}

	@Transactional
	public List<UcsawsRoles> getList() {
		return super.getList();
	}
	
	
    public UcsawsRoles  obtenerRolByID(Integer idRol){
      
    List<UcsawsRoles> resultado;
    UcsawsRoles e = new UcsawsRoles();
    String hql;
    hql = "select obj from " + claseEntidad
        + " obj where  idRol =:idRol";
    Query query = em.createQuery(hql);
    query.setParameter("idRol", idRol);
    resultado = query.getResultList();
    if (resultado.size() == 0) {
        return new  UcsawsRoles();
    } else if (resultado.size() == 1) {
        return  resultado.get(0) ;
    }
    return resultado.get(0)  ;
    }
    
    
    public List<UcsawsRoles> obtenerRolesByEvento(Integer idEvento){
    
    List<UcsawsRoles> resultado;
    UcsawsRoles e = new UcsawsRoles();
    String hql;
    hql = "select obj from " + claseEntidad
        + " obj where  ucsawsEvento.idEvento =:idEvento";
    Query query = em.createQuery(hql);
    query.setParameter("idEvento", idEvento);
    resultado = query.getResultList();
    if (resultado.size() == 0) {
        return new ArrayList<UcsawsRoles>();
    } else if (resultado.size() == 1) {
        return  resultado ;
    }
    return resultado ;
     
    
    }

}
