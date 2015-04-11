package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.Genero;

public interface GeneroDAOInterface extends DAOInterface{

	public void saveOrUpdate(Genero o);
	public void delete(Genero o);
	public List<Genero> getList();
	public void saveNativo(String query);
	public String SelectNativo(String query);
	public void updateNativo(String query);

}
