package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsTipoEvento;



public interface TipoEventoDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsTipoEvento o);
	public void delete(UcsawsTipoEvento o);
	public List<UcsawsTipoEvento> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);
	public UcsawsTipoEvento obtenerTipoEventoById(Integer idETipovento);
	public List<UcsawsTipoEvento> obtenerTipoEventoByIdEvento(Integer idEvento);

}
