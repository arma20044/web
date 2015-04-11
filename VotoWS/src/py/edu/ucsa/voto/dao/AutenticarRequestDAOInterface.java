package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.ws.schema.beans.AutenticarRequest;
import py.edu.ucsa.voto.ws.schema.beans.VotarRequest;

public interface AutenticarRequestDAOInterface extends DAOInterface{

	public void saveOrUpdate(AutenticarRequest o);
	public void delete(AutenticarRequest o);
	public List<AutenticarRequest> getList();

}
