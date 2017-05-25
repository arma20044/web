package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsDistrito;





public interface DistritoDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsDistrito o);
	public void delete(UcsawsDistrito o);
	public List<UcsawsDistrito> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);
	public UcsawsDistrito obtenerDistritoById(Integer idDistrito);
	public List<UcsawsDistrito> obtenerDistritoByIdEvento(Integer idEvento);

}
