package py.edu.ucsa.voto.entity;
// default package
// Generated 25/04/2017 09:24:26 PM by Hibernate Tools 4.3.1

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
 * UcsawsZona generated by hbm2java
 */
@Entity
@Table(name = "ucsaws_zona")
public class UcsawsZona implements java.io.Serializable {

	@Id
	@Column(name = "id_zona", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "ucsaws_zona_seq", allocationSize = 1)
	private Integer idZona;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.LOCK })
	@JoinColumn(name = "id_distrito", referencedColumnName = "id_distrito")
	private UcsawsDistrito ucsawsDistrito;
	
	@Column(name = "desc_zona", nullable = false, length=1000)
	private String descZona;
	
	@Column(name = "nro_zona", nullable = false, length=1000)
	private String nroZona;

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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.LOCK })
	@JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
	private UcsawsEvento idEvento;
	

	public UcsawsZona() {
	}

	public UcsawsZona(Integer idZona, UcsawsDistrito ucsawsDistrito, UcsawsEvento idEvento) {
		this.idZona = idZona;
		this.ucsawsDistrito = ucsawsDistrito;
		this.idEvento = idEvento;
	}

	public UcsawsZona(Integer idZona, UcsawsDistrito ucsawsDistrito,
			String descZona, String nroZona, String usuarioIns,
			String usuarioUpd, Date fchIns, Date fchUpd, UcsawsEvento idEvento) {
		this.idZona = idZona;
		this.ucsawsDistrito = ucsawsDistrito;
		this.descZona = descZona;
		this.nroZona = nroZona;
		this.usuarioIns = usuarioIns;
		this.usuarioUpd = usuarioUpd;
		this.fchIns = fchIns;
		this.fchUpd = fchUpd;
		this.idEvento = idEvento;
		
	}

	public Integer getIdZona() {
		return this.idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public UcsawsDistrito getUcsawsDistrito() {
		return this.ucsawsDistrito;
	}

	public void setUcsawsDistrito(UcsawsDistrito ucsawsDistrito) {
		this.ucsawsDistrito = ucsawsDistrito;
	}

	public String getDescZona() {
		return this.descZona;
	}

	public void setDescZona(String descZona) {
		this.descZona = descZona;
	}

	public String getNroZona() {
		return this.nroZona;
	}

	public void setNroZona(String nroZona) {
		this.nroZona = nroZona;
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

	public UcsawsEvento getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(UcsawsEvento idEvento) {
		this.idEvento = idEvento;
	}



}
