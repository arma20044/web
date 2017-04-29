package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsVotos;



public interface VotoDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsVotos o);
	public void delete(UcsawsVotos o);
	public List<UcsawsVotos> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);

}
