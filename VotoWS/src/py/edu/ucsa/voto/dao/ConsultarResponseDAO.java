package py.edu.ucsa.voto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.ws.schema.beans.ConsultarResponse;

@Repository("consultarResponseDAO")
@Transactional(readOnly = true)
public class ConsultarResponseDAO extends AbstractSpringDAO implements
ConsultarResponseDAOInterface {

	public ConsultarResponseDAO() {
		claseEntidad = "ConsultarResponse";
		nombreCampoID = "id_consultar_res";
		campoOrden = "id_consultar_res";
	}

	@Transactional
	public void saveOrUpdate(ConsultarResponse o) {
		if (o.getId_consultar_res() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(ConsultarResponse o) {
		super.delete(o);
	}

	@Transactional
	public List<ConsultarResponse> getList() {
		return super.getList();
	}


}
