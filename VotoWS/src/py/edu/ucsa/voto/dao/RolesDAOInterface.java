package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsRoles;



public interface RolesDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsRoles o);
	public void delete(UcsawsRoles o);
	public List<UcsawsRoles> getList();
	public UcsawsRoles  obtenerRolByID(Integer idRol);
	public List<UcsawsRoles> obtenerRolesByEvento(Integer idEvento);
	    
}
