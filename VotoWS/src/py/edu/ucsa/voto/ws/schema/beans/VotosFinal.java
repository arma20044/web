package py.edu.ucsa.voto.ws.schema.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import py.edu.ucsa.voto.entity.AbstractFechaUsuario;

@XmlRootElement(name = "VotarResponse", namespace = "http://voto.ucsa.edu.py/co")
@XmlType(name = "", propOrder = { "codigo", "descripcion" })
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "UCSAWS_VOTAR_RES")
@Inheritance(strategy = InheritanceType.JOINED)
public class VotosFinal extends AbstractFechaUsuario {
	
	@XmlTransient
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UCSAWS_VOTAR_RES_SEQ")
	@SequenceGenerator(name = "UCSAWS_VOTAR_RES_SEQ", sequenceName = "UCSAWS_VOTAR_RES_SEQ", allocationSize = 1)
	private Integer id_votar_res;
	
	@XmlTransient
	@OneToOne(optional=false)
	@JoinColumn(nullable = false, name = "id_votar_req", referencedColumnName = "id_votar_req")
	private VotarRequest votarRequest;

	@XmlElement(name = "codigo", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, precision = 20)
	private BigDecimal codigo;

	@XmlElement(name = "descripcion", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, length = 500)
	private String descripcion;

	public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId_votar_res() {
		return id_votar_res;
	}

	public void setId_votar_res(Integer id_votar_res) {
		this.id_votar_res = id_votar_res;
	}

	public VotarRequest getVotarRequest() {
		return votarRequest;
	}

	public void setVotarRequest(VotarRequest votarRequest) {
		this.votarRequest = votarRequest;
	}

	


	

}