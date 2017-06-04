package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsCandidatos;





public interface CandidatosDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsCandidatos o);
	public void delete(UcsawsCandidatos o);
	public List<UcsawsCandidatos> getList();
	public List<UcsawsCandidatos> obtenerCandidatosByEvento(Integer idEvento);
	//public UcsawsCandidatos obtenerNacionalidadByCodigoYNombre(String codigo, String nombre, Integer idEvento);
	//public UcsawsCandidatos obtenerNacionalidadByPaisyEvento(Integer idPais, Integer idEvento);
	public UcsawsCandidatos obtenerCandidatosByID(Integer idCandidato);
	// public UcsawsCandidatos obtenerNacionalidadByPais (Integer idPais );
	/*public UcsawsEvento obtenerEventoByFecha(Date fecha);
	
	public UcsawsEvento obtenerEventoByCodigo(String codigoEvento);
	public UcsawsEvento obtenerEventoByRangoFechaTipoEvento(Generic g);
	public UcsawsEvento obtenerEventoByRangoFechaEvento(Generic g);*/
}
