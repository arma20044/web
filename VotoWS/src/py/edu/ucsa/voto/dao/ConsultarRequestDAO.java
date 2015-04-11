package py.edu.ucsa.voto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.ws.schema.beans.ConsultarRequest;

@Repository("consultarRequestDAO")
@Transactional(readOnly = true)
public class ConsultarRequestDAO extends AbstractSpringDAO implements
ConsultarRequestDAOInterface {

	public ConsultarRequestDAO() {
		claseEntidad = "ConsultarRequest";
		nombreCampoID = "id_consultar_req";
		campoOrden = "id_consultar_req";
	}

	@Transactional
	public void saveOrUpdate(ConsultarRequest o) {
		if (o.getId_consultar_req() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(ConsultarRequest o) {
		super.delete(o);
	}

	@Transactional
	public List<ConsultarRequest> getList() {
		return super.getList();
	}

}
