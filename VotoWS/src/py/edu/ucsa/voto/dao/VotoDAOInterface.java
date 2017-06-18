package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsCandidatos;
import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsTipoLista;
import py.edu.ucsa.voto.entity.UcsawsVotos;



public interface VotoDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsVotos o);
	public void delete(UcsawsVotos o);
	public List<UcsawsVotos> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);
	//public List<Object> obtenerCandidatosConVotoByEvento(Integer idEvento, Integer tipoLista);
	 public List<UcsawsVotos> obtenerVotosByEvento(Integer idEvento, Integer tipoLista);
	 public List<Object> obtenerConteoVotoByEvento(  UcsawsTipoLista tipoLista);

}
