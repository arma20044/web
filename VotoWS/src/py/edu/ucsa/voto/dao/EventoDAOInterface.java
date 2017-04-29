package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsEvento;



public interface EventoDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsEvento o);
	public void delete(UcsawsEvento o);
	public List<UcsawsEvento> getList();
	public UcsawsEvento obtenerEventoByFecha(Date fecha);
	public UcsawsEvento obtenerEventoById(Integer idEvento);

}
