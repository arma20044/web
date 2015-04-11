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

@XmlRootElement(name = "QueryGenericoResponse", namespace = "http://voto.ucsa.edu.py/co")
@XmlType(name = "", propOrder = { "codigo", "query_generico_response" })
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "ucsaws_query_generico_res")
@Inheritance(strategy = InheritanceType.JOINED)
public class QueryGenericoResponse extends AbstractFechaUsuario {
	
	@XmlTransient
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ucsaws_query_generico_res_seq")
	@SequenceGenerator(name = "ucsaws_query_generico_res_seq", sequenceName = "ucsaws_query_generico_res_seq", allocationSize = 1)
	private Integer id_query_generico_res;
	
	@XmlElement(name = "codigo", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false)
	private Integer codigo;
	
	@XmlElement(name = "query_generico_response", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, length = 10000)
	private String query_generico_response;
	
	@XmlTransient
	@OneToOne(optional=false)
	@JoinColumn(nullable = false, name = "id_query_generico_req", referencedColumnName = "id_query_generico_req")
	private QueryGenericoRequest queryGenericoRequest;

	public Integer getId_query_generico_res() {
		return id_query_generico_res;
	}

	public void setId_query_generico_res(Integer id_query_generico_res) {
		this.id_query_generico_res = id_query_generico_res;
	}

	public QueryGenericoRequest getQueryGenericoRequest() {
		return queryGenericoRequest;
	}

	public void setQueryGenericoRequest(QueryGenericoRequest queryGenericoRequest) {
		this.queryGenericoRequest = queryGenericoRequest;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getQuery_generico_response() {
		return query_generico_response;
	}

	public void setQuery_generico_response(String query_generico_response) {
		this.query_generico_response = query_generico_response;
	}

	

}