package py.edu.ucsa.voto.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DAOInterface {

	public Object save(Object obj);

	public void delete(Object obj);

	public List getList();

	public Object update(Object obj);

	public Object find(Integer id);

	public Object find(String id);

	public List findByParent(String attr, Object parent);

	public List hqlQuery(String hql, int firstRow, int maxRows);

	public List hqlQuery(String hql);

	public List hqlQuery(String string, Map params, Integer firstRow, int i);
	
	public List hqlQuery(String string, Map params);

	public String getClaseEntidad();

	public void setClaseEntidad(String claseEntidad);

	public String getNombreCampoID();

	public void setNombreCampoID(String nombreCampoID);

	public String getCampoOrden();

	public void setCampoOrden(String campoOrden);
	
	public Date getDataBaseTime();

}
