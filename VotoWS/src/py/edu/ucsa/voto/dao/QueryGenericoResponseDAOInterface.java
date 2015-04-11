package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoResponse;

public interface QueryGenericoResponseDAOInterface extends DAOInterface{

	public void saveOrUpdate(QueryGenericoResponse o);
	public void delete(QueryGenericoResponse o);
	public List<QueryGenericoResponse> getList();

}
