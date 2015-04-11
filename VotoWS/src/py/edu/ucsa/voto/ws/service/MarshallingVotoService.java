package py.edu.ucsa.voto.ws.service;


import py.edu.ucsa.voto.ws.schema.beans.AutenticarRequest;
import py.edu.ucsa.voto.ws.schema.beans.AutenticarResponse;
import py.edu.ucsa.voto.ws.schema.beans.ConsultarRequest;
import py.edu.ucsa.voto.ws.schema.beans.ConsultarResponse;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoRequest;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoResponse;
import py.edu.ucsa.voto.ws.schema.beans.VotarRequest;
import py.edu.ucsa.voto.ws.schema.beans.VotarResponse;



public interface MarshallingVotoService {

	public final static String NAMESPACE = "http://voto.ucsa.edu.py/co";
	public final static String CONSULTAR_REQUEST = "ConsultarRequest";
	public final static String VOTAR_REQUEST = "VotarRequest";
	public final static String AUTENTICAR_REQUEST = "AutenticarRequest";
	public final static String QUERY_GENERICO_REQUEST = "QueryGenericoRequest";
//	public final static String REALIZAR_TRANSACCION_REQUEST = "RealizarTransaccionRequest";
//	public final static String ANULAR_COMPROBANTE_REQUEST = "AnularComprobanteRequest";
//	public final static String SOLICITAR_TRANSACCION_REQUEST = "SolicitarTransaccionRequest";
//	public final static String CONFIRMAR_TRANSACCION_REQUEST = "ConfirmarTransaccionRequest";
//	public final static String REGULARIZAR_TRANSACCION_REQUEST = "RegularizarTransaccionRequest";
//	

	/**
	 * consulta si es posible realizar una consulta al WS
	 */
	public ConsultarResponse consultarTransaccion(
			ConsultarRequest request);
	
	/**
	 * cliente pide votar
	 */
	public VotarResponse votar(
			VotarRequest request);


	/**
	 * realiza la transaccion y retorna el resultado
	 */
	public AutenticarResponse autenticar(
			AutenticarRequest request);

	/**
//	 * recibe una consulta generica
//	 */
	public QueryGenericoResponse queryGenerico(
			QueryGenericoRequest request);
//
//	/**
//	 * realiza la solicitud de transaccion y retorna el resultado
//	 */
//	public SolicitarTransaccionResponse solicitarTransaccion(
//			SolicitarTransaccionRequest request);
//
//	/**
//	 * realiza la confirmacion de la transaccion y retorna resultado
//	 */
//	public ConfirmarTransaccionResponse confirmarTransaccion(
//			ConfirmarTransaccionRequest request);
//	
//	/**
//	 * realiza la regularizacion de la transaccion y retorna el resultado
//	 */
//	
//	public RegularizarTransaccionResponse regularizarTransaccion(
//			RegularizarTransaccionRequest request);
	
}
