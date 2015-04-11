package py.edu.ucsa.voto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ucsaws_users")
public class Users extends AbstractFechaUsuario implements Serializable {
	
	
	@Id
	@Column(name = "id_user", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ucsaws_users_seq")
	@SequenceGenerator(name = "ucsaws_users_seq", sequenceName = "ucsaws_users_seq", allocationSize = 1)
	private Integer id_user;
	
	@Column(name="id_persona" , nullable = false)
	private Integer id_persona;

	@Column(name="usuario", nullable = false, length=15)
	private String usuario;
	
	@Column(name="pass", nullable = false, length=15)
	private String pass;

	@Column(name="es_admin")
	private Boolean es_admin;

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Boolean getEs_admin() {
		return es_admin;
	}

	public void setEs_admin(Boolean es_admin) {
		this.es_admin = es_admin;
	}
	

	

}