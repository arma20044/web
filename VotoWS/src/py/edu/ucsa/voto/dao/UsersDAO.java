package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.Date;
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
	
			
			
	public UcsawsUsers consultarUsuario(String user , String pass){
		List<UcsawsUsers> resultado;
		UcsawsUsers e = new UcsawsUsers();
		String hql;
		hql = "select obj from " + claseEntidad + " obj where  usuario = :user and pass = :pass";
		Query query = em.createQuery(hql);
		query.setParameter("user", user);
		query.setParameter("pass", pass);
		
		resultado = query.getResultList();
		if (resultado.size()==0){
			return e;
		}
		else
			if(resultado.size()==1){
				return (UcsawsUsers) resultado.get(0);
			}
		return (UcsawsUsers) resultado.get(0);
		
		//return null;
		
	}

}
