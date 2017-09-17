package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsTipoActa;

 

public interface TipoActasDAOInterface extends DAOInterface {

	public void saveOrUpdate(UcsawsTipoActa o);

	public void delete(UcsawsTipoActa o);

	public List<UcsawsTipoActa> getList();

	public UcsawsTipoActa obtenerTipoActa(Integer codigoActa, Integer tipoActa,Integer idEvento);

	public UcsawsTipoActa obtenerTipoActaById(Integer idActa);
	
	public UcsawsTipoActa obtenerTipoActaByCodigo(String codigo, Integer idEvento);
	
	public List<UcsawsTipoActa> obtenerTipoActaByIdEvento(Integer idEvento);

}
