package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsCandidatos;
import py.edu.ucsa.voto.entity.UcsawsTipoLista;
import py.edu.ucsa.voto.entity.UcsawsVotos;



@Repository("votoDAO")
@Transactional(readOnly = true)
public class VotoDAO extends AbstractSpringDAO implements VotoDAOInterface {

  public VotoDAO() {
    claseEntidad = "UcsawsVotos";
    nombreCampoID = "idVoto";
    campoOrden = "idVoto";
  }

  @Transactional
  public void saveOrUpdate(UcsawsVotos o) {
    if (o.getIdVoto() == null)
      super.save(o);
    else
      super.update(o);
  }

  @Transactional
  public void delete(UcsawsVotos o) {
    super.delete(o);
  }

  @Transactional
  public List<UcsawsVotos> getList() {
    return super.getList();
  }



  /*
   * public UcsawsEvento obtenerEventoByFecha(Date fecha){ List<UcsawsEvento> resultado;
   * UcsawsEvento e = new UcsawsEvento(); String hql; hql = "select obj from " + claseEntidad +
   * " obj where  :fecha  between fchDesde and fchHasta"; Query query = em.createQuery(hql);
   * query.setParameter("fecha", fecha); resultado = query.getResultList(); if
   * (resultado.size()==0){ return e; } else if(resultado.size()==1){ return (UcsawsEvento)
   * resultado.get(0); } return (UcsawsEvento) resultado.get(0);
   * 
   * //return null;
   * 
   * }
   */

  /*
   * public List<Object> obtenerCandidatosConVotoByEvento(Integer idEvento, Integer tipoLista){
   * idEvento = 1; tipoLista = 23; List<Object> resultado; UcsawsVotos e = new UcsawsVotos(); String
   * hql; hql = "select voto.idLista.nombreLista, count(voto) from UcsawsVotos voto " +
   * " where voto.idLista.idEvento.idEvento =:idEvento and voto.idLista.ucsawsTipoLista.idTipoLista =:tipoLista"
   * + " group by voto.idLista.nombreLista order by 2"; Query query = em.createQuery(hql);
   * query.setParameter("idEvento", idEvento); query.setParameter("tipoLista", tipoLista); resultado
   * = query.getResultList(); if (resultado.size() == 0) { return new ArrayList<Object>(); } else if
   * (resultado.size() == 1) { return resultado ; } return resultado ;
   * 
   * 
   * }
   */

  public List<UcsawsVotos> obtenerVotosByEvento(Integer idEvento, Integer tipoLista) {

    List<UcsawsVotos> resultado;
    UcsawsVotos e = new UcsawsVotos();
    String hql;
    hql =
        "select obj from " + claseEntidad + " obj where  obj.idLista.idEvento.idEvento =:idEvento";
    Query query = em.createQuery(hql);
    query.setParameter("idEvento", idEvento);
    resultado = query.getResultList();
    if (resultado.size() == 0) {
      return new ArrayList<UcsawsVotos>();
    } else if (resultado.size() == 1) {
      return resultado;
    }
    return resultado;


  }


  public List<Object> obtenerConteoVotoByEvento(UcsawsTipoLista tipoLista) {

    List<Object> resultado;
    String hql;
    hql =
        "select lista.nombreLista, count(voto.idVoto) " + " from " + claseEntidad + " voto "
            + " join voto.idLista lista " + " join lista.ucsawsTipoLista tipoLista "

            + "where  lista.idEvento =:idEvento and tipoLista = :tipoLista"
            + " group by lista.nombreLista "
            + " order by count(voto.idVoto) desc";
    Query query = em.createQuery(hql);
    query.setParameter("idEvento", tipoLista.getIdEvento());
    query.setParameter("tipoLista", tipoLista);
    resultado = query.getResultList();
    if (resultado.size() == 0) {
      return new ArrayList<Object>();
    } else if (resultado.size() == 1) {
      return resultado;
    }
    return resultado;


  }
}
