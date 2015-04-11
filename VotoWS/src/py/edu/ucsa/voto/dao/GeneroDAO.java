package py.edu.ucsa.voto.dao;

import java.util.List;

import javax.persistence.Query;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.Genero;



@Repository("generoDAO")
@Transactional(readOnly = true)
public class GeneroDAO extends AbstractSpringDAO implements
GeneroDAOInterface {

	public GeneroDAO() {
		claseEntidad = "Genero";
		nombreCampoID = "id_genero";
		campoOrden = "id_genero";
	}

	@Transactional
	public void saveOrUpdate(Genero o) {
		if (o.getId_genero() == null)
			super.save(o);
		else
			super.update(o);
	}

	@Transactional
	public void delete(Genero o) {
		super.delete(o);
	}

	@Transactional
	public List<Genero> getList() {
		return super.getList();
	}
	
	//@Transactional
	public void saveNativo(String query){
		
		
		em.createNativeQuery(query).executeUpdate();
		
		
	}
	
	public String SelectNativo(String query){
		
		//Integer contador = 0;
	
		List<Object[]> resultado = null;
		
		Query consulta = em.createNativeQuery(query);
	    
		resultado = consulta.getResultList();
		    
		JSONArray filas = new JSONArray();

		for(Object[] objectArray:resultado)
		{
		  JSONArray fila = new JSONArray();
		  for(Object object:objectArray)
		  {
		    fila.add(object);
		  }
		  filas.add(fila);
		}
		
	
		
		String obj2= filas.toJSONString();
		
		
		
		
		
	//System.out.println(jsonArr.get(0));
		
				
				
				
		
	//	String res = Arrays.toString(resultado);
		
		//String res2 = res.substring(1, res.length()-1);
		
		//while (contador <= resultado.size() ){
			
			
		//resultado2 = resultado2 + "," + resultado.get(contador);
		//}		
//		resultado2 = (String) resultado[0];
//		resultado3 = (String) resultado[1].toString();
//		resultado4 = (String) resultado[2];
//		
//		if(resultado.length == 4){
//			resultado5 = (String) resultado[3];
//		}
//		
//		return resultado2 + "," + resultado3 + "," + resultado4 + "," + resultado5;
//		String resultado2 = "";
//		int contador = 0;
//		while (contador < resultado.length ){
//			if (contador == 0){
//				resultado2 = (String) resultado[contador];
//				contador = contador + 1;
//			}
//			else{
//			resultado2 = resultado2 + "," + (String) resultado[contador];
//			contador = contador + 1;}
//			
//		}
		
		return obj2;
	}
	
	public void updateNativo(String query){
		
		em.createNativeQuery(query).executeUpdate();
	}


}
