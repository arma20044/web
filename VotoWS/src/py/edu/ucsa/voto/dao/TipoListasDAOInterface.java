package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsTipoLista;

public interface TipoListasDAOInterface extends DAOInterface {

	public void saveOrUpdate(UcsawsTipoLista o);

	public void delete(UcsawsTipoLista o);

	public List<UcsawsTipoLista> getList();

	public UcsawsTipoLista obtenerTipoLista(Integer nroLista, Integer tipoLista,Integer idEvento);

	public UcsawsTipoLista obtenerTipoListaById(Integer idLista);
	
	public UcsawsTipoLista obtenerTipoListaByCodigo(String codigo, Integer idEvento);

}
