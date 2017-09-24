package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsMiembroMesa;



public interface MiembroMesaDAOInterface extends DAOInterface {

  public void saveOrUpdate(UcsawsMiembroMesa o);

  public void delete(UcsawsMiembroMesa o);

  public List<UcsawsMiembroMesa> getList();

  public UcsawsMiembroMesa obtenerMiembroMesa(Integer codigoMiembroMesa, Integer persona,
      Integer idEvento);

  public UcsawsMiembroMesa obtenerMiembroMesaById(Integer idMiembroMesa);



  public List<UcsawsMiembroMesa> obtenerMiembroMesaByIdEvento(Integer idEvento);
  
  public List<UcsawsMiembroMesa> obtenerMiembroMesaByIdEventoByActa(Integer idEvento, Integer idActa);

}
