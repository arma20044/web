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
@Table(name = "ucsaws_actas")
public class UcsawsActas implements java.io.Serializable {


  @Id
  @Column(name = "id_acta", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
  @SequenceGenerator(name = "generator", sequenceName = "ucsaws_actas_seq", allocationSize = 1)
  private Integer idActa;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @Cascade(value = { CascadeType.LOCK })
  @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
  private UcsawsEvento idEvento;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @Cascade(value = { CascadeType.LOCK })
  @JoinColumn(name = "id_Mesa", referencedColumnName = "id_Mesa")
  private UcsawsMesa idMesa;
  
  
  
  @Column(name = "observacion", nullable = false, length=1000)
  private String observacion;
  
  @Column(name = "descripcion", nullable = false, length=1000)
  private String descripcion;
  
  @Column(name = "fecha", nullable = false)
  private Date fecha;
  
  @Column(name = "numero_votantes", nullable = false)
  private Integer numeroVotantes;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @Cascade(value = { CascadeType.LOCK })
  @JoinColumn(name = "id_tipo_acta", referencedColumnName = "id_tipo_acta")
  private UcsawsTipoActa tipoActa;
  
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

  public Integer getIdActa() {
    return idActa;
  }

  public void setIdActa(Integer idActa) {
    this.idActa = idActa;
  }

  public UcsawsEvento getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(UcsawsEvento idEvento) {
    this.idEvento = idEvento;
  }

  public UcsawsMesa getIdMesa() {
    return idMesa;
  }

  public void setIdMesa(UcsawsMesa idMesa) {
    this.idMesa = idMesa;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Integer getNumeroVotantes() {
    return numeroVotantes;
  }

  public void setNumeroVotantes(Integer numeroVotantes) {
    this.numeroVotantes = numeroVotantes;
  }

  public UcsawsTipoActa getTipoActa() {
    return tipoActa;
  }

  public void setTipoActa(UcsawsTipoActa tipoActa) {
    this.tipoActa = tipoActa;
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
