package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsGenero;



public interface GeneroDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsGenero o);
	public void delete(UcsawsGenero o);
	public List<UcsawsGenero> getList();
	/*public UcsawsGenero obtenerEventoByFecha(Date fecha);
	public UcsawsGenero obtenerEventoById(Integer idEvento);
	public UcsawsGenero obtenerEventoByCodigo(String codigoEvento);
	public UcsawsGenero obtenerEventoByRangoFechaTipoEvento(Generic g);
	public UcsawsGenero obtenerEventoByRangoFechaEvento(Generic g);*/
	public List<UcsawsGenero> obtenerGeneroByIdEvento(Integer idEvento);
	public List<UcsawsGenero> obtenerGeneroByCodigoGEneroIdEvento(String codGenero,Integer idEvento);
	public List<UcsawsGenero> obtenerGeneroById (Integer idGenero);

}
