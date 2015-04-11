package py.edu.ucsa.voto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.ws.schema.beans.ConsultarRequest;
import py.edu.ucsa.voto.ws.schema.beans.VotarRequest;

@Repository("votarRequestDAO")
@Transactional(readOnly = true)
public class VotarRequestDAO extends AbstractSpringDAO implements
VotarRequestDAOInterface {

	public VotarRequestDAO() {
		claseEntidad = "VotarRequest";
		nombreCampoID = "id_votar_req";
		campoOrden = "id_votar_req";
	}

	@Transactional
	public void saveOrUpdate(VotarRequest o) {
		if (o.getId_votar_req() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(VotarRequest o) {
		super.delete(o);
	}

	@Transactional
	public List<VotarRequest> getList() {
		return super.getList();
	}

}
