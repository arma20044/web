package py.edu.ucsa.voto.entity;
// Generated 22/04/2017 10:08:37 PM by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;








import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * UcsawsEvento generated by hbm2java
 */

@Entity
@Table(name = "ucsaws_evento")
public class UcsawsEvento  implements Serializable {

	
	public UcsawsEvento(Integer idEvento, UcsawsTipoEvento ucsawsTipoEvento,
			String descripcion, Date fchDesde, Date fchHasta, Date fchIns,
			Date fchUpd, String usuarioIns, String usuarioUpd, String nroEvento) {
		//super();
		this.idEvento = idEvento;
		this.ucsawsTipoEvento = ucsawsTipoEvento;
		this.descripcion = descripcion;
		this.fchDesde = fchDesde;
		this.fchHasta = fchHasta;
		this.fchIns = fchIns;
		this.fchUpd = fchUpd;
		this.usuarioIns = usuarioIns;
		this.usuarioUpd = usuarioUpd;
		this.nroEvento = nroEvento;
	}

	@Id
	@Column(name = "id_evento", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "ucsaws_evento_seq", allocationSize = 1)
	private Integer idEvento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.LOCK })
	@JoinColumn(name = "id_tipo_evento", referencedColumnName = "id_tipo_evento")
	private UcsawsTipoEvento ucsawsTipoEvento;
	
	@Column(name = "descripcion", nullable = false, length=1000)
	private String descripcion;
	
	@Column(name = "fch_desde", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fchDesde;
	
	@Column(name = "fch_hasta", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fchHasta;
	
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
	
	@Column(name = "nro_evento", nullable = false)
	private String nroEvento;

	public UcsawsEvento() {
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public UcsawsTipoEvento getUcsawsTipoEvento() {
		return ucsawsTipoEvento;
	}

	public void setUcsawsTipoEvento(UcsawsTipoEvento ucsawsTipoEvento) {
		this.ucsawsTipoEvento = ucsawsTipoEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFchDesde() {
		return fchDesde;
	}

	public void setFchDesde(Date fchDesde) {
		this.fchDesde = fchDesde;
	}

	public Date getFchHasta() {
		return fchHasta;
	}

	public void setFchHasta(Date fchHasta) {
		this.fchHasta = fchHasta;
	}

	public Date getFchIns() {
		return fchIns;
	}

	public void setFchIns(Date fchIns) {
		this.fchIns = fchIns;
	}

	public Date getFchUpd() {
		return fchUpd;
	}

	public void setFchUpd(Date fchUpd) {
		this.fchUpd = fchUpd;
	}

	public String getUsuarioIns() {
		return usuarioIns;
	}

	public void setUsuarioIns(String usuarioIns) {
		this.usuarioIns = usuarioIns;
	}

	public String getUsuarioUpd() {
		return usuarioUpd;
	}

	public void setUsuarioUpd(String usuarioUpd) {
		this.usuarioUpd = usuarioUpd;
	}

	public String getNroEvento() {
		return nroEvento;
	}

	public void setNroEvento(String nroEvento) {
		this.nroEvento = nroEvento;
	}

	

}
