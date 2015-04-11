package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.ws.schema.beans.VotarResponse;

public interface VotarResponseDAOInterface extends DAOInterface{

	public void saveOrUpdate(VotarResponse o);
	public void delete(VotarResponse o);
	public List<VotarResponse> getList();

}
