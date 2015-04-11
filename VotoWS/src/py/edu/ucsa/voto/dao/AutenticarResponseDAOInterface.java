package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.Users;
import py.edu.ucsa.voto.ws.schema.beans.AutenticarResponse;

public interface AutenticarResponseDAOInterface extends DAOInterface{

	public void saveOrUpdate(AutenticarResponse o);
	public void delete(AutenticarResponse o);
	public List<AutenticarResponse> getList();
	public List<Users> getUserAutenticado(String usuario, String contrasenha);

}
