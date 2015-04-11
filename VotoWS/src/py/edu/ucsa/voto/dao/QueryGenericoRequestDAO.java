package py.edu.ucsa.voto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoRequest;



@Repository("queryGenericoRequestDAO")
@Transactional(readOnly = true)
public class QueryGenericoRequestDAO extends AbstractSpringDAO implements
QueryGenericoRequestDAOInterface {

	public QueryGenericoRequestDAO() {
		claseEntidad = "QueryGenericoRequest";
		nombreCampoID = "id_query_generico_req";
		campoOrden = "id_query_generico_req";
	}

	@Transactional
	public void saveOrUpdate(QueryGenericoRequest o) {
		if (o.getId_query_generico_req() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(QueryGenericoRequest o) {
		super.delete(o);
	}

	@Transactional
	public List<QueryGenericoRequest> getList() {
		return super.getList();
	}

}
