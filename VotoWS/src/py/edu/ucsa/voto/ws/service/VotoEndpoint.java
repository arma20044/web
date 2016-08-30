/*
 * Copyright 2007-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package py.edu.ucsa.voto.ws.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateQueryException;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import py.edu.ucsa.voto.dao.AutenticarRequestDAOInterface;
import py.edu.ucsa.voto.dao.AutenticarResponseDAOInterface;
import py.edu.ucsa.voto.dao.ConsultarRequestDAOInterface;
import py.edu.ucsa.voto.dao.ConsultarResponseDAOInterface;
import py.edu.ucsa.voto.dao.GeneroDAOInterface;
import py.edu.ucsa.voto.dao.QueryGenericoRequestDAOInterface;
import py.edu.ucsa.voto.dao.QueryGenericoResponseDAOInterface;
import py.edu.ucsa.voto.dao.VotarRequestDAOInterface;
import py.edu.ucsa.voto.dao.VotarResponseDAOInterface;
import py.edu.ucsa.voto.entity.Genero;
import py.edu.ucsa.voto.entity.Users;
import py.edu.ucsa.voto.ws.schema.beans.AutenticarRequest;
import py.edu.ucsa.voto.ws.schema.beans.AutenticarResponse;
import py.edu.ucsa.voto.ws.schema.beans.ConsultarRequest;
import py.edu.ucsa.voto.ws.schema.beans.ConsultarResponse;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoRequest;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoResponse;
import py.edu.ucsa.voto.ws.schema.beans.VotarRequest;
import py.edu.ucsa.voto.ws.schema.beans.VotarResponse;



/**
 * Voto service endpoint.
 * 
 * 
 */
@Endpoint
public class VotoEndpoint implements MarshallingVotoService {

	private static final Logger logger = Logger
			.getLogger(VotoEndpoint.class);

	/**
	 * Define el código de Error desconocido para los mensajes de respuesta del
	 * Web Service.
	 */
	private static final int _CODIGO_ERROR_DESCONOCIDO = -9999;
	
	private static final int _CODIGO_OK = 7777;
	
	private static final int _CODIGO_VOTO_OK = 6666;
	
	private static final int _CODIGO_OK_AUTENTICADO_ADMIN = 12345;
	
	private static final String _DESCRIPCION_OK_AUTENTICADO_ADMIN = "El usuario autenticado es un ADMIN";
	
	private static final int _CODIGO_OK_AUTENTICADO_VOTANTE = 54321;
	
	private static final String _DESCRIPCION_OK_AUTENTICADO_VOTANTE = "El usuario autenticado es un VOTANTE";
	
	
	private static final int _CODIGO_NO_AUTENTICADO = 919;
	
	private static final String _DESCRIPCION_NO_AUTENTICADO = "Autenticacion Fallida";
	/**
	 * Define la descripcion de Error desconocido para los mensajes de respuesta
	 * del Web Service.
	 */
	private static final String _DESCRIPCION_ERROR_DESCONOCIDO = "ERROR DESCONOCIDO";
	
	private static final String _CONSULTA_OK_DESCRIPCION = "CONSULTA OK";
	
	private static final String _VOTO_OK_DESCRIPCION = "VOTO OK";
	
	private static final int _CODIGO_OK_INSERT = 2233;
	
	private static final int _CODIGO_OK_SELECT = 2244;
	
	private static final int _CODIGO_OK_UPDATE = 2255;
	
	private static final int _CODIGO_OK_DELETE = 2266;

	@Autowired
	private VotarRequestDAOInterface votarRequestDAO;
	@Autowired
	private VotarResponseDAOInterface votarResponseDAO;
	@Autowired
	private ConsultarRequestDAOInterface consultarRequestDAO;
	@Autowired
	private ConsultarResponseDAOInterface consultarResponseDAO;
	@Autowired
	private GeneroDAOInterface generoDAO;
	@Autowired
	private AutenticarRequestDAOInterface autenticarRequestDAO;
	@Autowired
	private AutenticarResponseDAOInterface autenticarResponseDAO;
	@Autowired
	private QueryGenericoRequestDAOInterface queryGenericoRequestDAO;
	@Autowired
	private QueryGenericoResponseDAOInterface queryGenericoResponseDAO;

	
//	@Autowired
//	private RealizarTransaccionRequestDAOInterface realizarTransaccionRequestDAO;
//	@Autowired
//	private RealizarTransaccionResponseDAOInterface realizarTransaccionResponseDAO;
//	@Autowired
//	private SolicitarTransaccionRequestDAOInterface solicitarTransaccionRequestDAO;
//	@Autowired
//	private SolicitarTransaccionResponseDAOInterface solicitarTransaccionResponseDAO;
//	@Autowired
//	private ConfirmarTransaccionRequestDAOInterface confirmarTransaccionRequestDAO;
//	@Autowired
//	private ConfirmarTransaccionResponseDAOInterface confirmarTransaccionResponseDAO;
//	@Autowired
//	private RegularizarTransaccionRequestDAOInterface regularizarTransaccionRequestDAO;
//	@Autowired
//	private RegularizarTransaccionResponseDAOInterface regularizarTransaccionResponseDAO;




	@PayloadRoot(localPart = CONSULTAR_REQUEST, namespace = NAMESPACE)
	public ConsultarResponse consultarTransaccion(
			ConsultarRequest request) {
		//Date fecha = consultarTransaccionRequestDAO.getDataBaseTime(); //se obtiene la fecha
		//request.setFchins(fecha); //se setea la fecha
		
		ConsultarResponse response = new ConsultarResponse();

		try {
			// enviar a cola request
//			String idMessageRequest = gfvJmsMessageManager
//					.enviarObjectMessage(request);
			// recibir response
			consultarRequestDAO.saveOrUpdate(request);
			
			response.setCodigo(new BigDecimal(_CODIGO_OK));
			response.setDescripcion(_CONSULTA_OK_DESCRIPCION);
			response.setConsultarRequest(request);

		} catch (Exception e) {
			logger.error(e.getStackTrace(), e);

			response.setCodigo(new BigDecimal(_CODIGO_OK));
			response.setDescripcion(_CONSULTA_OK_DESCRIPCION);
			response.setConsultarRequest(request);
		}

		consultarResponseDAO.saveOrUpdate(response);
		return response;
	}

	@PayloadRoot(localPart = VOTAR_REQUEST, namespace = NAMESPACE)
	public VotarResponse votar(
			VotarRequest request) {
		//Date fecha = consultarTransaccionRequestDAO.getDataBaseTime(); //se obtiene la fecha
		//request.setFchins(fecha); //se setea la fecha
		
		VotarResponse response = new VotarResponse();

		try {
			// enviar a cola request
//			String idMessageRequest = gfvJmsMessageManager
//					.enviarObjectMessage(request);
			// recibir response
			votarRequestDAO.saveOrUpdate(request);
			
			response.setCodigo(new BigDecimal(_CODIGO_VOTO_OK));
			response.setDescripcion(_VOTO_OK_DESCRIPCION);
			response.setVotarRequest(request);
			
			Genero genero = new Genero();
			
			genero.setDescripcion("Masculino");
			
			
			generoDAO.save(genero);
			

		} catch (Exception e) {
			logger.error(e.getStackTrace(), e);

			response.setCodigo(new BigDecimal(_CODIGO_VOTO_OK));
			response.setDescripcion(_VOTO_OK_DESCRIPCION);
			response.setVotarRequest(request);
		}

		votarResponseDAO.saveOrUpdate(response);
		return response;
	}
	
	
	
	@PayloadRoot(localPart = AUTENTICAR_REQUEST, namespace = NAMESPACE)
	public AutenticarResponse autenticar(
			AutenticarRequest request) {
		//Date fecha = consultarTransaccionRequestDAO.getDataBaseTime(); //se obtiene la fecha
		//request.setFchins(fecha); //se setea la fecha
		
		AutenticarResponse response = new AutenticarResponse();

		try {
			// enviar a cola request
//			String idMessageRequest = gfvJmsMessageManager
//					.enviarObjectMessage(request);
			// recibir response
			autenticarRequestDAO.saveOrUpdate(request);
			
			
			
			//agregar consulta a la db preguntando por el user y pass
			//si encuntra ok sino no
			 List<Users> autenticado = 
			autenticarResponseDAO.getUserAutenticado(request.getUsuario(), request.getContrasenha());
			 
			 if (!autenticado.isEmpty())
			 {
				 if(autenticado.get(0).getEs_admin()==true){
					 response.setCodigo(new BigDecimal(_CODIGO_OK_AUTENTICADO_ADMIN));
						response.setDescripcion(_DESCRIPCION_OK_AUTENTICADO_ADMIN);
						response.setAutenticarRequest(request);
				 }
				 else{
					 response.setCodigo(new BigDecimal(_CODIGO_OK_AUTENTICADO_VOTANTE));
						response.setDescripcion(_DESCRIPCION_OK_AUTENTICADO_VOTANTE);
						response.setAutenticarRequest(request);
				 }
				 
			
			
			
			 }
			 
			 else{
				 response.setCodigo(new BigDecimal(_CODIGO_NO_AUTENTICADO));
					response.setDescripcion(_DESCRIPCION_NO_AUTENTICADO);
					response.setAutenticarRequest(request);
					
			 }

		} catch (Exception e) {
			logger.error(e.getStackTrace(), e);

			response.setCodigo(new BigDecimal(_CODIGO_ERROR_DESCONOCIDO));
			response.setDescripcion(e.getMessage());
			response.setAutenticarRequest(request);
			
		}

		autenticarResponseDAO.saveOrUpdate(response);
		return response;
	}
	
	
	@PayloadRoot(localPart = QUERY_GENERICO_REQUEST, namespace = NAMESPACE)
	public QueryGenericoResponse queryGenerico(
			QueryGenericoRequest request) {
		//Date fecha = consultarTransaccionRequestDAO.getDataBaseTime(); //se obtiene la fecha
		//request.setFchins(fecha); //se setea la fecha
		
		QueryGenericoResponse response = new QueryGenericoResponse();

		try {
			// enviar a cola request
//			String idMessageRequest = gfvJmsMessageManager
//					.enviarObjectMessage(request);
			// recibir response
			queryGenericoRequestDAO.saveOrUpdate(request);
			
			//PARA INSERTAR
			if (request.getTipo_query_generico()==1){
				generoDAO.saveNativo(request.getQuery_generico());
				
				response.setCodigo(_CODIGO_OK_INSERT);
				response.setQuery_generico_response("INSERT OK");
				
				response.setQueryGenericoRequest(request);
			}
			
			else
				//PARA CONSULTAR
				if(request.getTipo_query_generico()==2){
					String string = generoDAO.SelectNativo(request.getQuery_generico());
					

					
				//String[] parts = ((String) string).split(",");
					//String part1 =arrObj.
					//String part2 = parts[1]; 
					//String part3 = parts[2]; 
					
					response.setCodigo(_CODIGO_OK_SELECT);
					response.setQuery_generico_response(string);
					
					response.setQueryGenericoRequest(request);
				}
				else
					//PARA MODIFICAR
					if(request.getTipo_query_generico()==3){
						generoDAO.updateNativo(request.getQuery_generico());
						

						
					//String[] parts = ((String) string).split(",");
						//String part1 =arrObj.
						//String part2 = parts[1]; 
						//String part3 = parts[2]; 
						
						response.setCodigo(_CODIGO_OK_UPDATE);
						response.setQuery_generico_response("UPDATE OK");
						
						response.setQueryGenericoRequest(request);
			
			
					}
					else
						//PARA ELIMINAR
						if(request.getTipo_query_generico()==4){
							
							try {
								generoDAO.updateNativo(request.getQuery_generico());
							} catch (HibernateQueryException e) {
								// TODO: handle exception
								e.getMessage();
								e.printStackTrace();
								
							}
							
							

							
						//String[] parts = ((String) string).split(",");
							//String part1 =arrObj.
							//String part2 = parts[1]; 
							//String part3 = parts[2]; 
							
							response.setCodigo(_CODIGO_OK_DELETE);
							response.setQuery_generico_response("DELETE OK");
							
							response.setQueryGenericoRequest(request);
				
				
						}
			

		} catch (Exception e) {
			logger.error(e.getStackTrace(), e);

			response.setCodigo(_CODIGO_ERROR_DESCONOCIDO);
			response.setQuery_generico_response("ERRORRRRRRR");
			response.setQueryGenericoRequest(request);
		}
		
		if(response.getQuery_generico_response().length() <  500 )
		{
			queryGenericoResponseDAO.saveOrUpdate(response);
			
		}
		
		
		
		return response;
	}
	

	

	public ConsultarRequestDAOInterface getConsultarRequestDAO() {
		return consultarRequestDAO;
	}

	public void setConsultaRequestDAO(
			ConsultarRequestDAOInterface consultarRequestDAO) {
		this.consultarRequestDAO = consultarRequestDAO;
	}

	public ConsultarResponseDAOInterface getConsultarResponseDAO() {
		return consultarResponseDAO;
	}

	public void setConsultarResponseDAO(
			ConsultarResponseDAOInterface consultarResponseDAO) {
		this.consultarResponseDAO = consultarResponseDAO;
	}

	public VotarRequestDAOInterface getVotarRequestDAO() {
		return votarRequestDAO;
	}

	public void setVotarRequestDAO(VotarRequestDAOInterface votarRequestDAO) {
		this.votarRequestDAO = votarRequestDAO;
	}

	public VotarResponseDAOInterface getVotarResponseDAO() {
		return votarResponseDAO;
	}

	public void setVotarResponseDAO(VotarResponseDAOInterface votarResponseDAO) {
		this.votarResponseDAO = votarResponseDAO;
	}

	public QueryGenericoRequestDAOInterface getQueryGenericoRequestDAO() {
		return queryGenericoRequestDAO;
	}

	public void setQueryGenericoRequestDAO(
			QueryGenericoRequestDAOInterface queryGenericoRequestDAO) {
		this.queryGenericoRequestDAO = queryGenericoRequestDAO;
	}

	public QueryGenericoResponseDAOInterface getQueryGenericoResponseDAO() {
		return queryGenericoResponseDAO;
	}

	public void setQueryGenericoResponseDAO(
			QueryGenericoResponseDAOInterface queryGenericoResponseDAO) {
		this.queryGenericoResponseDAO = queryGenericoResponseDAO;
	}

	
	
	

	
	


	


	
	
}
