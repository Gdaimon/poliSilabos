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
@Table(name = "par_nucleo_tematico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParNucleoTematico.findAll", query = "SELECT p FROM ParNucleoTematico p"),
    @NamedQuery(name = "ParNucleoTematico.findById", query = "SELECT p FROM ParNucleoTematico p WHERE p.id = :id"),
    @NamedQuery(name = "ParNucleoTematico.findByDescripcion", query = "SELECT p FROM ParNucleoTematico p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ParNucleoTematico.findByFechaCreacion", query = "SELECT p FROM ParNucleoTematico p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParNucleoTematico.findByEstadoNucleo", query = "SELECT p FROM ParNucleoTematico p WHERE p.estadoNucleo = :estadoNucleo")})
public class ParNucleoTematico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "estado_nucleo")
    private boolean estadoNucleo;
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia")
    @ManyToOne
    private ParMaterias codMateria;

    public ParNucleoTematico() {
    }

    public ParNucleoTematico(Integer id) {
        this.id = id;
    }

    public ParNucleoTematico(Integer id, String descripcion, Date fechaCreacion, boolean estadoNucleo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoNucleo = estadoNucleo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean getEstadoNucleo() {
        return estadoNucleo;
    }

    public void setEstadoNucleo(boolean estadoNucleo) {
        this.estadoNucleo = estadoNucleo;
    }

    public ParMaterias getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(ParMaterias codMateria) {
        this.codMateria = codMateria;
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
        if (!(object instanceof ParNucleoTematico)) {
            return false;
        }
        ParNucleoTematico other = (ParNucleoTematico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParNucleoTematico[ id=" + id + " ]";
    }
    
}
