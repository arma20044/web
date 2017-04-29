package py.edu.ucsa.voto.entity;
// Generated 27/04/2017 10:00:56 PM by Hibernate Tools 4.3.1

import java.util.Date;

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
 * UcsawsVotosBlanco generated by hbm2java
 */
@Entity
@Table(name = "ucsaws_votos_blanco")
public class UcsawsVotosBlanco implements java.io.Serializable {

	@Id
	@Column(name = "id_voto_blanco", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "ucsaws_voto_blanco", allocationSize = 1)
	private Integer idVotoBlanco;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.LOCK })
	@JoinColumn(name = "id_tipo_lista", referencedColumnName = "id_tipo_lista")
	private UcsawsTipoLista idTipoLista;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.LOCK })
	@JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
	private UcsawsMesa idMesa;
	
	
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

	public UcsawsVotosBlanco() {
	}

	public UcsawsVotosBlanco(Integer idVotoBlanco, UcsawsTipoLista idTipoLista, UcsawsMesa idMesa,
			Date fchIns, String usuarioIns, UcsawsEvento idEvento) {
		this.idVotoBlanco = idVotoBlanco;
		this.idTipoLista = idTipoLista;
		this.idMesa = idMesa;
		this.fchIns = fchIns;
		this.usuarioIns = usuarioIns;
		this.idEvento = idEvento;
	}

	public UcsawsVotosBlanco(Integer idVotoBlanco, UcsawsTipoLista idTipoLista, UcsawsMesa idMesa,
			Date fchIns, Date fchUpd, String usuarioIns, String usuarioUpd,
			UcsawsEvento idEvento) {
		this.idVotoBlanco = idVotoBlanco;
		this.idTipoLista = idTipoLista;
		this.idMesa = idMesa;
		this.fchIns = fchIns;
		this.fchUpd = fchUpd;
		this.usuarioIns = usuarioIns;
		this.usuarioUpd = usuarioUpd;
		this.idEvento = idEvento;
	}

	public Integer getIdVotoBlanco() {
		return this.idVotoBlanco;
	}

	public void setIdVotoBlanco(Integer idVotoBlanco) {
		this.idVotoBlanco = idVotoBlanco;
	}

	public UcsawsTipoLista getIdTipoLista() {
		return this.idTipoLista;
	}

	public void setIdTipoLista(UcsawsTipoLista idTipoLista) {
		this.idTipoLista = idTipoLista;
	}

	public UcsawsMesa getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(UcsawsMesa idMesa) {
		this.idMesa = idMesa;
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

	public UcsawsEvento getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(UcsawsEvento idEvento) {
		this.idEvento = idEvento;
	}

}
