package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsPais;
import py.edu.ucsa.voto.entity.UcsawsVigenciaHorarioXPais;




public interface VigenciaDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsVigenciaHorarioXPais o);
	public void delete(UcsawsVigenciaHorarioXPais o);
	public List<UcsawsVigenciaHorarioXPais> getList();
	public UcsawsVigenciaHorarioXPais obtenerVigenciaById(Integer idVigencia);
	public List<UcsawsVigenciaHorarioXPais> obtenerVigenciaByIdEvento(UcsawsEvento evento);
	public List<UcsawsVigenciaHorarioXPais> obtenerVigenciaByPais(UcsawsPais pais);
}
