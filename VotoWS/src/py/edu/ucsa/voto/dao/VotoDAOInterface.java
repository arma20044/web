package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsTipoLista;
import py.edu.ucsa.voto.entity.UcsawsVotante;
import py.edu.ucsa.voto.entity.UcsawsVotos;
import py.edu.ucsa.voto.entity.UcsawsVotosBlanco;



public interface VotoDAOInterface extends DAOInterface {

  public void saveOrUpdate(UcsawsVotos o);

  public void delete(UcsawsVotos o);

  public List<UcsawsVotos> getList();

  // public UcsawsEvento obtenerEventoByFecha(Date fecha);
  // public List<Object> obtenerCandidatosConVotoByEvento(Integer idEvento, Integer tipoLista);
  public List<UcsawsVotos> obtenerVotosByEvento(Integer idEvento, Integer tipoLista);

  public List<Object> obtenerConteoVotoByEvento(UcsawsTipoLista tipoLista);

  public boolean VotarYActualizarVotante(UcsawsVotos votoPresidente, UcsawsVotos votoSenador,
      UcsawsVotos votoParlasur, UcsawsVotosBlanco votoPresidenteBlanco,
      UcsawsVotosBlanco votoSenadorBlanco, UcsawsVotosBlanco votoParlasurBlanco,
      UcsawsVotante votante);
  
  
  public Integer conteoVotosXMesaXEvento(Integer idMesa, Integer idEvento);

}
