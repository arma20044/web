package py.edu.ucsa.voto.ws.schema.beans;

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

@XmlRootElement(name = "QueryGenericoRequest", namespace = "http://voto.ucsa.edu.py/co")
@XmlType(name = "", propOrder = { "tipo_query_generico", "query_generico" })
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "ucsaws_query_generico_req")
@Inheritance(strategy = InheritanceType.JOINED)
public class QueryGenericoRequest extends AbstractFechaUsuario {
	
	@XmlTransient
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ucsaws_query_generico_req_seq")
	@SequenceGenerator(name = "ucsaws_query_generico_req_seq", sequenceName = "ucsaws_query_generico_req_seq", allocationSize = 1)
	private Integer id_query_generico_req;

	

	@XmlElement(name = "tipo_query_generico", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, precision = 20)
	private Integer tipo_query_generico;

	@XmlElement(name = "query_generico", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, length = 1000)
	private String query_generico;

	

	public Integer getId_query_generico_req() {
		return id_query_generico_req;
	}

	public void setId_query_generico_req(Integer id_query_generico_req) {
		this.id_query_generico_req = id_query_generico_req;
	}

	public Integer getTipo_query_generico() {
		return tipo_query_generico;
	}

	public void setTipo_query_generico(Integer tipo_query_generico) {
		this.tipo_query_generico = tipo_query_generico;
	}

	public String getQuery_generico() {
		return query_generico;
	}

	public void setQuery_generico(String query_generico) {
		this.query_generico = query_generico;
	}




}