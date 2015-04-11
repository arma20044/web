package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.ws.schema.beans.ConsultarResponse;

public interface ConsultarResponseDAOInterface extends DAOInterface{

	public void saveOrUpdate(ConsultarResponse o);
	public void delete(ConsultarResponse o);
	public List<ConsultarResponse> getList();

}
