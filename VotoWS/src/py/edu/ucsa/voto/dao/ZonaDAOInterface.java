package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsDistrito;
import py.edu.ucsa.voto.entity.UcsawsZona;





public interface ZonaDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsZona o);
	public void delete(UcsawsZona o);
	public List<UcsawsZona> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);
	public UcsawsZona obtenerZonaById(Integer idZona);
	public List<UcsawsZona> obtenerZonaByIdEvento(Integer idEvento);

}
