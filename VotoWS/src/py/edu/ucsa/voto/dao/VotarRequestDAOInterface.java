package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.ws.schema.beans.ConsultarRequest;
import py.edu.ucsa.voto.ws.schema.beans.VotarRequest;

public interface VotarRequestDAOInterface extends DAOInterface{

	public void saveOrUpdate(VotarRequest o);
	public void delete(VotarRequest o);
	public List<VotarRequest> getList();

}
