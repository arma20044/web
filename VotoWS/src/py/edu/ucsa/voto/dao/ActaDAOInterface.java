package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsActas;



public interface ActaDAOInterface extends DAOInterface {

  public void saveOrUpdate(UcsawsActas o);

  public void delete(UcsawsActas o);

  public List<UcsawsActas> getList();



  public UcsawsActas obtenerActaById(Integer idActa);



  public List<UcsawsActas> obtenerActaByIdEvento(Integer idEvento);

}
