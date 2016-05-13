package org.api.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "par_facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParFacultad.findAll", query = "SELECT p FROM ParFacultad p"),
    @NamedQuery(name = "ParFacultad.findById", query = "SELECT p FROM ParFacultad p WHERE p.id = :id"),
    @NamedQuery(name = "ParFacultad.findByNombreFacultad", query = "SELECT p FROM ParFacultad p WHERE p.nombreFacultad = :nombreFacultad"),
    @NamedQuery(name = "ParFacultad.findByCiudadFacultad", query = "SELECT p FROM ParFacultad p WHERE p.ciudadFacultad = :ciudadFacultad"),
    @NamedQuery(name = "ParFacultad.findByFechaCreacion", query = "SELECT p FROM ParFacultad p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParFacultad.findByEstadoFacultad", query = "SELECT p FROM ParFacultad p WHERE p.estadoFacultad = :estadoFacultad")})
public class ParFacultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_facultad")
    private String nombreFacultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ciudad_facultad")
    private String ciudadFacultad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_facultad")
    private boolean estadoFacultad;
    @OneToMany(mappedBy = "idFacultad")
    private Collection<ParDepartamento> parDepartamentoCollection;

    public ParFacultad() {
    }

    public ParFacultad(Integer id) {
        this.id = id;
    }

    public ParFacultad(Integer id, String nombreFacultad, String ciudadFacultad, Date fechaCreacion, boolean estadoFacultad) {
        this.id = id;
        this.nombreFacultad = nombreFacultad;
        this.ciudadFacultad = ciudadFacultad;
        this.fechaCreacion = fechaCreacion;
        this.estadoFacultad = estadoFacultad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getCiudadFacultad() {
        return ciudadFacultad;
    }

    public void setCiudadFacultad(String ciudadFacultad) {
        this.ciudadFacultad = ciudadFacultad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getEstadoFacultad() {
        return estadoFacultad;
    }

    public void setEstadoFacultad(boolean estadoFacultad) {
        this.estadoFacultad = estadoFacultad;
    }

    @XmlTransient
    public Collection<ParDepartamento> getParDepartamentoCollection() {
        return parDepartamentoCollection;
    }

    public void setParDepartamentoCollection(Collection<ParDepartamento> parDepartamentoCollection) {
        this.parDepartamentoCollection = parDepartamentoCollection;
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
        if (!(object instanceof ParFacultad)) {
            return false;
        }
        ParFacultad other = (ParFacultad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParFacultad[ id=" + id + " ]";
    }
    
}
