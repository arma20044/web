package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.ws.schema.beans.ConsultarRequest;

public interface ConsultarRequestDAOInterface extends DAOInterface{

	public void saveOrUpdate(ConsultarRequest o);
	public void delete(ConsultarRequest o);
	public List<ConsultarRequest> getList();

}
