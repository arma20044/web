package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsNacionalidad;



public interface NacionalidadDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsNacionalidad o);
	public void delete(UcsawsNacionalidad o);
	public List<UcsawsNacionalidad> getList();
	public List<UcsawsNacionalidad> obtenerNacionalidadByEvento(Integer idEvento);
	public UcsawsNacionalidad obtenerNacionalidadByCodigoYNombre(String codigo, String nombre, Integer idEvento);
	public UcsawsNacionalidad obtenerNacionalidadByPaisyEvento(Integer idPais, Integer idEvento);
	public UcsawsNacionalidad obtenerNacionalidadByID(Integer idNacionalidad);
	 public UcsawsNacionalidad obtenerNacionalidadByPais (Integer idPais );
	/*public UcsawsEvento obtenerEventoByFecha(Date fecha);
	
	public UcsawsEvento obtenerEventoByCodigo(String codigoEvento);
	public UcsawsEvento obtenerEventoByRangoFechaTipoEvento(Generic g);
	public UcsawsEvento obtenerEventoByRangoFechaEvento(Generic g);*/
}
