package py.edu.ucsa.voto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.ws.schema.beans.ConsultarResponse;
import py.edu.ucsa.voto.ws.schema.beans.VotarResponse;

@Repository("votarResponseDAO")
@Transactional(readOnly = true)
public class VotarResponseDAO extends AbstractSpringDAO implements
VotarResponseDAOInterface {

	public VotarResponseDAO() {
		claseEntidad = "VotarResponse";
		nombreCampoID = "id_votar_res";
		campoOrden = "id_votar_res";
	}

	@Transactional
	public void saveOrUpdate(VotarResponse o) {
		if (o.getId_votar_res() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(VotarResponse o) {
		super.delete(o);
	}

	@Transactional
	public List<VotarResponse> getList() {
		return super.getList();
	}


}
