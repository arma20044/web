package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsUsers;



public interface UsersDAOInterface extends DAOInterface {

  public void saveOrUpdate(UcsawsUsers o);

  public void delete(UcsawsUsers o);

  public List<UcsawsUsers> getList();

  public UcsawsUsers consultarUsuario(String user, String pass);

  public UcsawsUsers consultarUsuario(String idPersona);

  public UcsawsUsers obtenerUserByID(Integer idUser);

  public List<UcsawsUsers> obtenerUserByEvento(Integer idEvento);


}
