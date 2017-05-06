package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsPais;

public interface PaisDAOInterface extends DAOInterface {

    public void saveOrUpdate(UcsawsPais o);

    public void delete(UcsawsPais o);

    public List<UcsawsPais> getList();

    public List<UcsawsPais> obtenerPaisByEvento(Integer idEvento);

    public UcsawsPais obtenerPaisByNombreYEvento(String codigo,Integer idEvento, String nombre);

    public  UcsawsPais  obtenerPaisById(Integer idPais);
    
    public  UcsawsPais  obtenerPaisByIdYEvento(Integer idPais, Integer idEvento);
    
    public List<UcsawsPais> obtenerPaisByEventoFueraNacionalidad(Integer idEvento);

}
