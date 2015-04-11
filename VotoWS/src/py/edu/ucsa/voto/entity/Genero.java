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
@Table(name = "ucsaws_genero")
public class Genero extends AbstractFechaUsuario implements Serializable {
	
	
	@Id
	@Column(name = "id_genero", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ucsaws_genero_seq")
	@SequenceGenerator(name = "ucsaws_genero_seq", sequenceName = "ucsaws_genero_seq", allocationSize = 1)
	private Integer id_genero;
	
	@Column(name="descripcion" , length = 20)
	private String descripcion;

	
//   @Column(name = "fch_ins", nullable  = false)
//   @Temporal(TemporalType.TIMESTAMP)
//   private Date fchins;
//   
//   @Column(name = "fch_upd", nullable  = true)
//   @Temporal(TemporalType.TIMESTAMP)
//   private Date fchupd;
//   
//   @Column(name = "usuario_ins" , nullable= false)
//   private String usuarioins;
//   
//   @Column(name = "usuario_upd" , nullable= true)
//   private String usuarioupd;

public Integer getId_genero() {
	return id_genero;
}

public void setId_genero(Integer id_genero) {
	this.id_genero = id_genero;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


   
   



	

}