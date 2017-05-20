package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsPersona;



public interface PersonaDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsPersona o);
	public void delete(UcsawsPersona o);
	public List<UcsawsPersona> getList();
	public List<UcsawsPersona> obtenerPersonaByEvento(Integer idEvento);
	public List<UcsawsPersona> obtenerPersonaByCedula(Integer cedula);
	public UcsawsPersona obtenerPersonaByIdPersona(Integer idPersona);
	
	/*public UcsawsEvento obtenerEventoByFecha(Date fecha);
	
	public UcsawsEvento obtenerEventoByCodigo(String codigoEvento);
	public UcsawsEvento obtenerEventoByRangoFechaTipoEvento(Generic g);
	public UcsawsEvento obtenerEventoByRangoFechaEvento(Generic g);*/
}
