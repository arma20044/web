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

@XmlRootElement(name = "AutenticarRequest", namespace = "http://voto.ucsa.edu.py/co")
@XmlType(name = "", propOrder = {  "usuario" , "contrasenha" })
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "UCSAWS_AUTENTICAR_REQ")
@Inheritance(strategy = InheritanceType.JOINED)
public class AutenticarRequest extends AbstractFechaUsuario {
	
	@XmlTransient
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UCSAWS_AUTENTICAR_REQ_SEQ")
	@SequenceGenerator(name = "UCSAWS_AUTENTICAR_REQ_SEQ", sequenceName = "UCSAWS_AUTENTICAR_REQ_SEQ", allocationSize = 1)
	private Integer id_autenticar_req;

	@XmlElement(name = "usuario", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, length = 15)
	private String usuario;

	@XmlElement(name = "contrasenha", namespace = "http://voto.ucsa.edu.py/co")
	@Column(nullable = false, length = 15)
	private String contrasenha;

	public Integer getId_autenticar_req() {
		return id_autenticar_req;
	}

	public void setId_autenticar_req(Integer id_autenticar_req) {
		this.id_autenticar_req = id_autenticar_req;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}
	

	


}