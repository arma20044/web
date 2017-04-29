package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.AbstractFechaUsuario;

public abstract class AbstractSpringDAO implements DAOInterface {

	protected String claseEntidad;

	public String getClaseEntidad() {
		return claseEntidad;
	}

	public void setClaseEntidad(String claseEntidad) {
		this.claseEntidad = claseEntidad;
	}

	public String getNombreCampoID() {
		return nombreCampoID;
	}

	public void setNombreCampoID(String nombreCampoID) {
		this.nombreCampoID = nombreCampoID;
	}

	public String getCampoOrden() {
		return campoOrden;
	}

	public void setCampoOrden(String campoOrden) {
		this.campoOrden = campoOrden;
	}

	protected String nombreCampoID;
	protected String campoOrden;
	protected EntityManager em = null;

	// public static final Logger logger = Logger.getAnonymousLogger();

	/**
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	/**
	 * Saves person.
	 */
	@Transactional(readOnly = false)
	public Object save(Object obj) {
		if (obj instanceof AbstractFechaUsuario) {

			/**
			 * Se realiza el casting corespondiente para invocar los metodos
			 * setFchupd() y setUsuarioupd()
			 */
			AbstractFechaUsuario afc = (AbstractFechaUsuario) obj;
			afc.setFchins(getDataBaseTime());
			afc.setUsuarioins("sistema");
			/*
			 * Funcionario funcionario = ((AndeInetOrgPerson)
			 * SecurityContextHolder
			 * .getContext().getAuthentication().getPrincipal())
			 * .getFuncionarioSession(); String codFuncionario; if (funcionario
			 * == null) { String[] tmp = SecurityContextHolder.getContext()
			 * .getAuthentication().getName().split("@"); codFuncionario =
			 * String.valueOf(Integer.parseInt(tmp[0] .substring(3))); } else {
			 * codFuncionario = funcionario.getNropersonal().toString(); }
			 * 
			 * afc.setUsuarioins(codFuncionario);
			 */
			// logger.debug("Usuario ins: " + afc.getUsuarioins());
		}
		em.persist(obj);
		return obj ;

	}

	/**
	 * Deletes person.
	 */
	@Transactional(readOnly = false)
	public void delete(Object obj) {
		em.remove(em.merge(obj));
	}

	/**
	 * Find persons.
	 */
	@SuppressWarnings("unchecked")
	public List getList() {
		return em.createQuery(
				"from " + claseEntidad + " order by " + campoOrden)
				.getResultList();
	}

	/**
	 * @return la hora y la fecha de la base de datos.
	 */
	public Date getDataBaseTime() {

		String sql = "select now() ";
		// sq.addScalar("system_datetime", Hibernate.TIMESTAMP);
		return (Date) em.createNativeQuery(sql).getSingleResult();

		// session.getTransaction().commit();

		// return sysdatetime;
	}

	@Transactional(readOnly = false)
	public Object update(Object obj) {
		if (obj instanceof AbstractFechaUsuario) {

			/**
			 * Se realiza el casting corespondiente para invocar los metodos
			 * setFchupd() y setUsuarioupd()
			 */
			AbstractFechaUsuario afc = (AbstractFechaUsuario) obj;
			//if(!(afc.getFchins()==null)){  //Se pregunta si existe fecha
			afc.setFchupd(getDataBaseTime()); //Se obtiene la fecha
			//}
			/*
			 * Funcionario funcionario = ((AndeInetOrgPerson)
			 * SecurityContextHolder
			 * .getContext().getAuthentication().getPrincipal())
			 * .getFuncionarioSession(); String codFuncionario; if (funcionario
			 * == null) { String[] tmp = SecurityContextHolder.getContext()
			 * .getAuthentication().getName().split("@"); codFuncionario =
			 * String.valueOf(Integer.parseInt(tmp[0] .substring(3))); } else {
			 * codFuncionario = funcionario.getNropersonal().toString(); }
			 * afc.setUsuarioupd(codFuncionario);
			 */
			// logger.debug("Usuario ins: " + afc.getUsuarioins());
		}
		return em.merge(obj);

	}

	public Object find(Integer id) {
		Query query = em.createQuery("select obj from " + claseEntidad
				+ " obj where obj." + nombreCampoID + "=:id");
		query.setParameter("id", id);
		// no funciona el singleResult por eso agrego este codigo
		List<Object> obj = query.getResultList();
		if (obj.size() == 1)
			return obj.get(0);
		return null;
	}

	public Object find(String id) {
		Query query = em.createQuery("select obj from " + claseEntidad
				+ " obj where obj." + nombreCampoID + "='" + id + "'");
		// no funciona el singleResult por eso agrego este codigo
		List<Object> obj = query.getResultList();
		if (obj.size() == 1)
			return obj.get(0);
		return null;
	}

	public List findByParent(String attr, Object parent) {
		Query query = em.createQuery("select obj from " + claseEntidad
				+ " obj where obj." + attr + "=:parent order by " + campoOrden);
		query.setParameter("parent", parent);
		return query.getResultList();
	}

	public List hqlQuery(String hql, int firstRow, int maxRows) {
		Query query = em.createQuery(hql);
		query.setMaxResults(maxRows);
		query.setFirstResult(firstRow);
		return query.getResultList();
	}

	public List hqlQuery(String hql) {
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	public List hqlQuery(String hql, Map params, Integer firstRow, int maxRows) {
		Query query = em.createQuery(hql);
		if (params != null) {
			for (Object name : params.keySet()) {
				query.setParameter((String) name, params.get(name));
			}
		}
		query.setMaxResults(maxRows);
		query.setFirstResult(firstRow);
		return query.getResultList();

	}

	public List hqlQuery(String hql, Map params) {
		Query query = em.createQuery(hql);
		if (params != null) {
			for (Object name : params.keySet()) {
				query.setParameter((String) name, params.get(name));
			}
		}
		return query.getResultList();

	}


	public Integer getRowCount(String query, Map params) {
		Long result = (Long) (hqlQuery(query, params)).get(0);

		return new Integer(result.intValue());
	}

}
