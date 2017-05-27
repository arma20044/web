package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsLocal;





public interface LocalDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsLocal o);
	public void delete(UcsawsLocal o);
	public List<UcsawsLocal> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);
	public UcsawsLocal obtenerLocalById(Integer idLocal);
	public List<UcsawsLocal> obtenerLocalByIdEvento(Integer idEvento);
	public List<UcsawsLocal> obtenerLocalByIdZona(Integer idZona);
}
