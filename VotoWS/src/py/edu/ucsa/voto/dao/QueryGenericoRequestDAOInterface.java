package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoRequest;

public interface QueryGenericoRequestDAOInterface extends DAOInterface{

	public void saveOrUpdate(QueryGenericoRequest o);
	public void delete(QueryGenericoRequest o);
	public List<QueryGenericoRequest> getList();

}
