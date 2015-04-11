package py.edu.ucsa.voto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.ws.schema.beans.AutenticarRequest;

@Repository("autenticarRequestDAO")
@Transactional(readOnly = true)
public class AutenticarRequestDAO extends AbstractSpringDAO implements
AutenticarRequestDAOInterface {

	public AutenticarRequestDAO() {
		claseEntidad = "AutenticarRequest";
		nombreCampoID = "id_autenticar_req";
		campoOrden = "id_autenticar_req";
	}

	@Transactional
	public void saveOrUpdate(AutenticarRequest o) {
		if (o.getId_autenticar_req() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(AutenticarRequest o) {
		super.delete(o);
	}

	@Transactional
	public List<AutenticarRequest> getList() {
		return super.getList();
	}

}
