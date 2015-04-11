package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.Users;
import py.edu.ucsa.voto.ws.schema.beans.AutenticarResponse;

@Repository("autenticarResponseDAO")
@Transactional(readOnly = true)
public class AutenticarResponseDAO extends AbstractSpringDAO implements
AutenticarResponseDAOInterface {

	public AutenticarResponseDAO() {
		claseEntidad = "AutenticarResponse";
		nombreCampoID = "id_autenticar_res";
		campoOrden = "id_autenticar_res";
	}

	@Transactional
	public void saveOrUpdate(AutenticarResponse o) {
		if (o.getId_autenticar_res() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(AutenticarResponse o) {
		super.delete(o);
	}

	@Transactional
	public List<AutenticarResponse> getList() {
		return super.getList();
	}
	
	public List<Users> getUserAutenticado(String usuario, String contrasenha){
		
		List<Users> resultado;
		String hql;
		hql = "select obj from Users obj where obj.usuario = :usuario and obj.pass =:contrasenha";
		Query query = em.createQuery(hql);
		query.setParameter("usuario", usuario);
		query.setParameter("contrasenha", contrasenha);
		resultado = query.getResultList();
		if (resultado == null){
			resultado = new ArrayList<Users>();
			return resultado;
		}
		
		else
			return resultado;
		
		
				
	}


}
