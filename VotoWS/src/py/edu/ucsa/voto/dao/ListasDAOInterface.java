package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsListas;



public interface ListasDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsListas o);
	public void delete(UcsawsListas o);
	public List<UcsawsListas> getList();
	public UcsawsListas obtenerLista(Integer nroLista, Integer tipoLista, Integer idEvento);
	public UcsawsListas obtenerListaByID(Integer idLista);
	public UcsawsListas obtenerLista(String codigo, Integer nroListaSeleccionada, Integer idEvento);
	
	
	public List<UcsawsListas> obtenerListaByEvento(Integer idEvento);
	//public UcsawsListas obtenerListaByEvento(Integer idPais, Integer idEvento);
	//public UcsawsListas obtenerListaByID(Integer idNacionalidad);
	

}
