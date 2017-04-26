package py.edu.ucsa.voto.dao;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsUsers;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoRequest;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoResponse;

@Repository("canalizadorDAO")
@Transactional(readOnly = true)
public class CanalizadorDAO {

	@Autowired
	EventoDAOInterface eventoDAO;
	
	@Autowired
	UsersDAOInterface usersDAO;

	public QueryGenericoResponse parearClase (QueryGenericoRequest request) throws JsonParseException, JsonMappingException, IOException{
		QueryGenericoResponse response = new QueryGenericoResponse();
		if(request.getTipo_query_generico()==1){// consultar clase UCSAWS_EVENTO
			
			//json string to java object;
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString  =request.getQuery_generico();
			Date fecha = mapper.readValue(jsonInString, Date.class);
			
			UcsawsEvento r = eventoDAO.obtenerEventoByFecha( fecha);
			if (r.getIdEvento()==null){
				response.setCodigo(2244);
				response.setQuery_generico_response("NO");
			}
			else{
				response.setCodigo(2244);
				
				//py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento eventoSinMapeo = new py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento();
				//eventoSinMapeo.setDescripcion(r.getDescripcion());
				
				
				ObjectMapper mapperObj =  new ObjectMapper();
				
				//printter
				

				ObjectMapper mapper2 = new ObjectMapper();
				//System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(eventoSinMapeo));
				
				
				//mapperObj.setVisibility(JsonMethod.FIELD, Visibility.ANY);
				//mapperObj.enable(DeserializationConfig.);
				String jsonStr = "";
				try {
					// get Employee object as a json string
					String json = mapper.writeValueAsString(r);
					mapperObj.writeValue(System.out, r);
					System.out.println(jsonStr);
					jsonStr = mapperObj.writeValueAsString(r);
					System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(r));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				//JSONArray filas = 
				//String obj2= filas.toJSONString();
				
				response.setQuery_generico_response(jsonStr);
			}
			
			
			
			
			
		}
		else
		if(request.getTipo_query_generico()==2){// insertar clase UCSAWS_EVENTO
			
		}
		else
		if(request.getTipo_query_generico()==3){// eliminar clase UCSAWS_EVENTO
			
		}
		else
		if(request.getTipo_query_generico()==4){// modificar clase UCSAWS_EVENTO
			
		}
		else
			if(request.getTipo_query_generico()==5){// consultar clase UCSAWS_USERS
				

				//json string to java object;
				ObjectMapper mapper = new ObjectMapper();
				String jsonInString  =request.getQuery_generico();
				UcsawsUsers u = mapper.readValue(jsonInString, UcsawsUsers.class);
				
				UcsawsUsers r = usersDAO.consultarUsuario(u.getUsuario(), u.getPass());
				if (r.getIdUser()==null){
					response.setCodigo(2244);
					response.setQuery_generico_response("NO");
				}
				else{
					response.setCodigo(2244);
					
					//py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento eventoSinMapeo = new py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento();
				//	eventoSinMapeo.setDescripcion(r.getDescripcion());
					
					
					ObjectMapper mapperObj =  new ObjectMapper();
					
					//printter
					

					ObjectMapper mapper2 = new ObjectMapper();
					//System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(eventoSinMapeo));
					
					
					//mapperObj.setVisibility(JsonMethod.FIELD, Visibility.ANY);
					//mapperObj.enable(DeserializationConfig.);
					String jsonStr = "";
					try {
						// get Employee object as a json string
						String json = mapper.writeValueAsString(r);
						mapperObj.writeValue(System.out, r);
						System.out.println(jsonStr);
						jsonStr = mapperObj.writeValueAsString(r);
						System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(r));
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					//JSONArray filas = 
					//String obj2= filas.toJSONString();
					
					response.setQuery_generico_response(jsonStr);
				}
			}
		
		return response;
		
	}

	public static JSONObject objectToJSONObject(Object object) {
		Object json = null;
		JSONObject jsonObject = null;
		try {
			json = new JSONTokener(object.toString()).nextValue();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (json instanceof JSONObject) {
			jsonObject = (JSONObject) json;
		}
		return jsonObject;
	}

}
