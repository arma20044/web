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
@Table(name = "ucsaws_tipo_acta")
public class UcsawsTipoActa implements java.io.Serializable{
  
  @Id
  @Column(name = "id_tipo_acta", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
  @SequenceGenerator(name = "generator", sequenceName = "ucsaws_tipo_acta_seq", allocationSize = 1)
  private Integer idTipoActa;
  
  @Column(name = "codigo_acta", nullable = false, length=5)
  private String codigoActa;
  
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

  public Integer getIdTipoActa() {
    return idTipoActa;
  }

  public void setIdTipoActa(Integer idTipoActa) {
    this.idTipoActa = idTipoActa;
  }

  public String getCodigoActa() {
    return codigoActa;
  }

  public void setCodigoActa(String codigoActa) {
    this.codigoActa = codigoActa;
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

 
  
}
