package py.edu.ucsa.voto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoResponse;

@Repository("queryGenericoResponseDAO")
@Transactional(readOnly = true)
public class QueryGenericoResponseDAO extends AbstractSpringDAO implements
QueryGenericoResponseDAOInterface {

	public QueryGenericoResponseDAO() {
		claseEntidad = "QueryGenericoResponse";
		nombreCampoID = "id_query_generico_res";
		campoOrden = "id_query_generico_res";
	}

	@Transactional
	public void saveOrUpdate(QueryGenericoResponse o) {
		if (o.getId_query_generico_res()  == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(QueryGenericoResponse o) {
		super.delete(o);
	}

	@Transactional
	public List<QueryGenericoResponse> getList() {
		return super.getList();
	}


}
