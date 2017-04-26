package py.edu.ucsa.voto.entity;
// Generated 25/04/2017 03:26:32 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * UcsawsGenero generated by hbm2java
 */
@Entity
@Table(name = "ucsaws_genero")
public class UcsawsGenero implements java.io.Serializable {

	
	@Id
	@Column(name = "id_genero", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "ucsaws_genero_seq", allocationSize = 1)
	private Integer idGenero;
	
	@Column(name = "descripcion", nullable = false, length=1000)
	private String descripcion;
	
	@Column(name = "fch_ins", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fchIns;
	
	@Column(name = "fch_upd", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fchUpd;
	
	@Column(name = "usuario_ins", nullable = false)
	private String usuarioIns;
	
	@Column(name = "usuario_upd", nullable = true)
	private String usuarioUpd;
	
	@Column(name = "codigo", nullable = false)
	private String codigo;

	@Column(name = "id_evento", nullable = false)
	private Integer idEvento;
	
	@Column(name = "id_persona", nullable = true)
	private Integer ucsawsPersonas;
	

	public UcsawsGenero() {
	}

	public UcsawsGenero(Integer idGenero, String descripcion, Date fchIns,
			String usuarioIns, Integer idEvento) {
		this.idGenero = idGenero;
		this.descripcion = descripcion;
		this.fchIns = fchIns;
		this.usuarioIns = usuarioIns;
		this.idEvento = idEvento;
	}

	public UcsawsGenero(Integer idGenero, String descripcion, Date fchIns,
			Date fchUpd, String usuarioIns, String usuarioUpd, String codigo,
			Integer idEvento, Integer ucsawsPersonas) {
		this.idGenero = idGenero;
		this.descripcion = descripcion;
		this.fchIns = fchIns;
		this.fchUpd = fchUpd;
		this.usuarioIns = usuarioIns;
		this.usuarioUpd = usuarioUpd;
		this.codigo = codigo;
		this.idEvento = idEvento;
		this.ucsawsPersonas = ucsawsPersonas;
	}

	public Integer getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFchIns() {
		return this.fchIns;
	}

	public void setFchIns(Date fchIns) {
		this.fchIns = fchIns;
	}

	public Date getFchUpd() {
		return this.fchUpd;
	}

	public void setFchUpd(Date fchUpd) {
		this.fchUpd = fchUpd;
	}

	public String getUsuarioIns() {
		return this.usuarioIns;
	}

	public void setUsuarioIns(String usuarioIns) {
		this.usuarioIns = usuarioIns;
	}

	public String getUsuarioUpd() {
		return this.usuarioUpd;
	}

	public void setUsuarioUpd(String usuarioUpd) {
		this.usuarioUpd = usuarioUpd;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}



}
