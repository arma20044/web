package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsUsers;



@Repository("usersDAO")
@Transactional(readOnly = true)
public class UsersDAO extends AbstractSpringDAO implements UsersDAOInterface {

  public UsersDAO() {
    claseEntidad = "UcsawsUsers";
    nombreCampoID = "idUser";
    campoOrden = "idUser";
  }

  @Transactional
  public void saveOrUpdate(UcsawsUsers o) {
    if (o.getIdEvento() == null)
      super.save(o);
    else
      super.update(o);
  }

  @Transactional
  public void delete(UcsawsUsers o) {
    super.delete(o);
  }

  @Transactional
  public List<UcsawsUsers> getList() {
    return super.getList();
  }



  public UcsawsUsers consultarUsuario(String user, String pass) {
    List<UcsawsUsers> resultado;
    UcsawsUsers e = new UcsawsUsers();
    String hql;
    hql = "select obj from " + claseEntidad + " obj where  usuario = :user and pass = :pass";
    Query query = em.createQuery(hql);
    query.setParameter("user", user);
    query.setParameter("pass", pass);

    resultado = query.getResultList();
    if (resultado.size() == 0) {
      return e;
    } else if (resultado.size() == 1) {
      return (UcsawsUsers) resultado.get(0);
    }
    return (UcsawsUsers) resultado.get(0);

    // return null;

  }

  public UcsawsUsers consultarUsuario(String id) {
    List<UcsawsUsers> resultado;
    UcsawsUsers e = new UcsawsUsers();
    String hql;
    hql =
        "select obj from " + claseEntidad
            + " obj where  obj. = :user and pass = :pass and ucsawsPersona.id =:personaid ";
    Query query = em.createQuery(hql);
    query.setParameter("habilitado", Integer.parseInt("1"));
    query.setParameter("sufrago", Integer.parseInt("0"));
    query.setParameter("personaid", id);
    resultado = query.getResultList();
    if (resultado.size() == 0) {
      return e;
    } else if (resultado.size() == 1) {
      return (UcsawsUsers) resultado.get(0);
    }
    return (UcsawsUsers) resultado.get(0);

    // return null;

  }

  public UcsawsUsers obtenerUserByID(Integer idUser) {

    List<UcsawsUsers> resultado;
    UcsawsUsers e = new UcsawsUsers();
    String hql;
    hql = "select obj from " + claseEntidad + " obj where  idUser =:idUser";
    Query query = em.createQuery(hql);
    query.setParameter("idUser", idUser);
    resultado = query.getResultList();
    if (resultado.size() == 0) {
      return new UcsawsUsers();
    } else if (resultado.size() == 1) {
      return resultado.get(0);
    }
    return resultado.get(0);
  }


  public List<UcsawsUsers> obtenerUserByEvento(Integer idEvento) {

    List<UcsawsUsers> resultado;
    UcsawsUsers e = new UcsawsUsers();
    String hql;
    hql = "select obj from " + claseEntidad + " obj where  idEvento.idEvento =:idEvento";
    Query query = em.createQuery(hql);
    query.setParameter("idEvento", idEvento);
    resultado = query.getResultList();
    if (resultado.size() == 0) {
      return new ArrayList<UcsawsUsers>();
    } else if (resultado.size() == 1) {
      return resultado;
    }
    return resultado;


  }

}
