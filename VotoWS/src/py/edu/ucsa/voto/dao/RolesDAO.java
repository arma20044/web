package py.edu.ucsa.voto.dao;

import java.util.List;

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

}
