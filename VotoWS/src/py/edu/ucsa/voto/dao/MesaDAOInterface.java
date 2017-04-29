package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsMesa;



public interface MesaDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsMesa o);
	public void delete(UcsawsMesa o);
	public List<UcsawsMesa> getList();
	public UcsawsMesa obtenerMesaByID(Integer idMesa);

}
