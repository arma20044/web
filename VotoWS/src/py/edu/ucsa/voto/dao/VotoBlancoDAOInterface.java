package py.edu.ucsa.voto.dao;

import java.util.List;

import py.edu.ucsa.voto.entity.UcsawsTipoLista;
import py.edu.ucsa.voto.entity.UcsawsVotosBlanco;




public interface VotoBlancoDAOInterface extends DAOInterface{

	public void saveOrUpdate(UcsawsVotosBlanco o);
	public void delete(UcsawsVotosBlanco o);
	public List<UcsawsVotosBlanco> getList();
	//public UcsawsEvento obtenerEventoByFecha(Date fecha);
	//public List<Object> obtenerCandidatosConVotoByEvento(Integer idEvento, Integer tipoLista);
	  
	 


}
