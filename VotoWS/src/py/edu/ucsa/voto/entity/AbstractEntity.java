/**
 * 
 */
package py.edu.ucsa.voto.entity;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author asu10012
 * 
 */
public abstract class AbstractEntity {

	/**
	 * logger de log4j
	 */
	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * Retorna un objeto Date con la fecha y hora como parametros.
	 * 
	 * @param fecha
	 *            La fecha en la cual se le quiere agregar una hora especifica.
	 * @param hora
	 *            La hora (hh:mm)a agregar al fecha recibida.
	 * @return el objeto Date con fecha y hora especificada en los parametros.
	 */
	protected Date setHoraAFecha(Date fecha, String hora) {

		logger.debug("RECIBIDO FECHA = " + fecha);
		/**
		 * El formato de hora es "hh:mm"
		 */
		int hour = Integer.parseInt(hora.substring(0, 2));
		int minute = Integer.parseInt(hora.substring(3, 5));

		logger.debug("hora despues del parser = " + hour);
		logger.debug("minutos despues del parser = " + minute);

		Calendar cal = Calendar.getInstance();
		if (fecha != null) {
			cal.setTime(fecha);
		}

		cal.set(Calendar.HOUR_OF_DAY, hour);

		cal.set(Calendar.MINUTE, minute);

		logger.debug("Fecha y hora obtenida = " + cal.getTime());

		fecha = cal.getTime();

		return fecha;
	}

	/**
	 * Retorna la hora String(hh:mm) obtenida del objeto Date parametro.
	 * 
	 * @param fecha
	 *            el objeto Date que contiene la hora requerida.
	 * @return El string que representa la hora requerida(hh:mm)
	 */
	protected String obtenerHoraDeFecha(Date fecha) {

		String hora = null;

		logger.debug("Se recibio la fecha = " + fecha);

		if (fecha != null) {

			Calendar cal = Calendar.getInstance();

			cal.setTime(fecha);

			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);

			if (hour < 10) {
				hora = "0" + hour;
			} else {
				hora = "" + hour;
			}

			if (minute < 10) {
				hora = hora + ":0" + minute;
			} else {
				hora = hora + ":" + minute;
			}

			logger.debug("La hora obtenida del objeto Date recibido = " + hora);
		}
		return hora;

	}

}
