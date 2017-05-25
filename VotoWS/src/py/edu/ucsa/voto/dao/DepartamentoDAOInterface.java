package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsDepartamento;



public interface DepartamentoDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsDepartamento o);
	public void delete(UcsawsDepartamento o);
	public List<UcsawsDepartamento> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);
	public UcsawsDepartamento obtenerDepartamentoById(Integer IdDepartamento);
	public List<UcsawsDepartamento> obtenerDepartamentoByIdEvento(Integer idEvento);

}
