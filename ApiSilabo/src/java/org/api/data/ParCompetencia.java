/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "par_competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParCompetencia.findAll", query = "SELECT p FROM ParCompetencia p"),
    @NamedQuery(name = "ParCompetencia.findById", query = "SELECT p FROM ParCompetencia p WHERE p.id = :id"),
    @NamedQuery(name = "ParCompetencia.findByCodCompetencia", query = "SELECT p FROM ParCompetencia p WHERE p.codCompetencia = :codCompetencia"),
    @NamedQuery(name = "ParCompetencia.findByDescripcion", query = "SELECT p FROM ParCompetencia p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ParCompetencia.findByFechaCreacion", query = "SELECT p FROM ParCompetencia p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParCompetencia.findByEstadoCompetencia", query = "SELECT p FROM ParCompetencia p WHERE p.estadoCompetencia = :estadoCompetencia")})
public class ParCompetencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cod_competencia")
    private Integer codCompetencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_competencia")
    private boolean estadoCompetencia;
    @JoinColumn(name = "id_creador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ParUsuarios idCreador;

    public ParCompetencia() {
    }

    public ParCompetencia(Integer id) {
        this.id = id;
    }

    public ParCompetencia(Integer id, String descripcion, Date fechaCreacion, boolean estadoCompetencia) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoCompetencia = estadoCompetencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodCompetencia() {
        return codCompetencia;
    }

    public void setCodCompetencia(Integer codCompetencia) {
        this.codCompetencia = codCompetencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getEstadoCompetencia() {
        return estadoCompetencia;
    }

    public void setEstadoCompetencia(boolean estadoCompetencia) {
        this.estadoCompetencia = estadoCompetencia;
    }

    public ParUsuarios getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(ParUsuarios idCreador) {
        this.idCreador = idCreador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParCompetencia)) {
            return false;
        }
        ParCompetencia other = (ParCompetencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParCompetencia[ id=" + id + " ]";
    }
    
}
