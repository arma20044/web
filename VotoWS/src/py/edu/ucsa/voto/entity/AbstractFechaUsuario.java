/**
 * 
 */
package py.edu.ucsa.voto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Armando Villalba
 * 
 *         FechaUsuario: Representa el registro del usuario, la fecha y la hora
 *         en que es realizado alguna operación(inserción/modificación) de algun
 *         registro del sistema.
 */
@XmlTransient
@MappedSuperclass
public abstract class AbstractFechaUsuario extends AbstractEntity implements
		Serializable {
	
	@XmlTransient
	@Column(name = "USUARIO_INS", nullable = true, length = 20)
	private String usuarioins;

	@XmlTransient
	@Column(name = "USUARIO_UPD", nullable = true, length = 20)
	private String usuarioupd;

	@XmlTransient
	@Column(name = "FCH_INS", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fchins;

	@XmlTransient
	@Column(name = "FCH_UPD", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fchupd;

	/**
	 * @return the usuarioins
	 */

	public String getUsuarioins() {
		return usuarioins;
	}

	/**
	 * @param usuarioins
	 *            the usuarioins to set
	 */
	public void setUsuarioins(String usuarioins) {
		this.usuarioins = usuarioins;
	}

	/**
	 * @return the usuarioupd
	 */

	public String getUsuarioupd() {
		return usuarioupd;
	}

	/**
	 * @param usuarioupd
	 *            the usuarioupd to set
	 */
	public void setUsuarioupd(String usuarioupd) {
		this.usuarioupd = usuarioupd;
	}

	/**
	 * @return the fchins
	 */

	public Date getFchins() {
		return fchins;
	}

	/**
	 * @param fchins
	 *            the fchins to set
	 */
	public void setFchins(Date fchins) {
		this.fchins = fchins;
	}

	/**
	 * @return the fchupd
	 */

	public Date getFchupd() {
		return fchupd;
	}

	/**
	 * @param fchupd
	 *            the fchupd to set
	 */
	public void setFchupd(Date fchupd) {
		this.fchupd = fchupd;
	}

}