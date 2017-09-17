package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsTipoMiembroMesa;

 
 

public interface TipoMiembroMesaDAOInterface extends DAOInterface {

	public void saveOrUpdate(UcsawsTipoMiembroMesa o);

	public void delete(UcsawsTipoMiembroMesa o);

	public List<UcsawsTipoMiembroMesa> getList();

	public UcsawsTipoMiembroMesa obtenerTipoMiembroMesa(Integer codigoMiembroMesa, Integer tipoMiembroMesa,Integer idEvento);

	public UcsawsTipoMiembroMesa obtenerTipoMiembroMesaById(Integer idMiembroMesa);
	
	public UcsawsTipoMiembroMesa obtenerTipoMiembroMesaByCodigo(String codigo, Integer idEvento);
	
	public List<UcsawsTipoMiembroMesa> obtenerTipoMiembroMesaByIdEvento(Integer idEvento);

}
