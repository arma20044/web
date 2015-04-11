package py.edu.ucsa.voto.ws.schema.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import py.edu.ucsa.voto.entity.AbstractFechaUsuario;

@XmlRootElement(name = "ConsultarRequest", namespace = "http://voto.ucsa.edu.py/co")
@XmlType(name = "", propOrder = { "origen_peticion", "cedula" })
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "GFVWS_CONSULTAR_REQ")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConsultarRequest extends AbstractFechaUsuario {
	
	@XmlTransient
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GFVWS_CONSULTAR_REQ_SEQ")
	@SequenceGenerator(name = "GFVWS_CONSULTAR_REQ_SEQ", sequenceName = "GFVWS_CONSULTAR_REQ_SEQ", allocationSize = 1)
	private Integer id_consultar_req;

	@XmlElement(name = "origen_peticion", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false)
	private Integer origen_peticion;

	@XmlElement(name = "cedula", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, length = 20)
	private String cedula;

	public Integer getId_consultar_req() {
		return id_consultar_req;
	}

	public void setId_consultar_req(Integer id_consultar_req) {
		this.id_consultar_req = id_consultar_req;
	}

	public Integer getOrigen_peticion() {
		return origen_peticion;
	}

	public void setOrigen_peticion(Integer origen_peticion) {
		this.origen_peticion = origen_peticion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	



}