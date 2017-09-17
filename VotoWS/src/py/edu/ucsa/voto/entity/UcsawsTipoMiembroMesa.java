package py.edu.ucsa.voto.entity;

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

@Entity
@Table(name = "ucsaws_tipo_miembros_mesa")
public class UcsawsTipoMiembroMesa implements java.io.Serializable{
  
  @Id
  @Column(name = "id_tipo_miembro_mesa", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
  @SequenceGenerator(name = "generator", sequenceName = "ucsaws_tipo_miembros_mesa_seq", allocationSize = 1)
  private Integer idTipoMiembroMesa;
  
  @Column(name = "codigo", nullable = false, length=5)
  private String codigo;
  
  @Column(name = "descripcion", nullable = false, length=100)
  private String descripcion;

  @ManyToOne(fetch = FetchType.EAGER)
  @Cascade(value = { CascadeType.LOCK })
  @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
  private UcsawsEvento idEvento;
  
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

  public Integer getIdTipoMiembroMesa() {
    return idTipoMiembroMesa;
  }

  public void setIdTipoMiembroMesa(Integer idTipoMiembroMesa) {
    this.idTipoMiembroMesa = idTipoMiembroMesa;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public UcsawsEvento getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(UcsawsEvento idEvento) {
    this.idEvento = idEvento;
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
  
  
   
 
  
}
