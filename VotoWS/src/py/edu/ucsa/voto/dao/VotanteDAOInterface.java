package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsVotante;



public interface VotanteDAOInterface extends DAOInterface {

  public void saveOrUpdate(UcsawsVotante o);

  public void delete(UcsawsVotante o);

  public List<UcsawsVotante> getList();

  public UcsawsVotante obtenerVotante(Integer idVotante);

  public UcsawsVotante obtenerVotanteSinSufragar(String idVotante);

  public UcsawsVotante obtenerVotanteById(Integer idVotante);

  public List<UcsawsVotante> obtenerVotantesByEvento(Integer idEvento);

  public UcsawsVotante obtenerVotanteByIdYEvento(Integer idVotante, Integer idEvento);

  public UcsawsVotante obtenerVotanteByIdPersonaYEvento(Integer idVotante, Integer idEvento);
}
