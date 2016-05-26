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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "par_objetivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParObjetivo.findAll", query = "SELECT p FROM ParObjetivo p"),
    @NamedQuery(name = "ParObjetivo.findById", query = "SELECT p FROM ParObjetivo p WHERE p.id = :id"),
    @NamedQuery(name = "ParObjetivo.findByDescripcion", query = "SELECT p FROM ParObjetivo p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ParObjetivo.findByFechaCreacion", query = "SELECT p FROM ParObjetivo p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParObjetivo.findByEstadoNucleo", query = "SELECT p FROM ParObjetivo p WHERE p.estadoNucleo = :estadoNucleo")})
public class ParObjetivo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_objetivo")
    private boolean estadoObjetivo;
    @ManyToMany(mappedBy = "parObjetivoCollection")
    private Collection<ParNucleoTematico> parNucleoTematicoCollection;

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

    public ParObjetivo() {
    }

    public ParObjetivo(Integer id) {
        this.id = id;
    }

    public ParObjetivo(Integer id, String descripcion, Date fechaCreacion, boolean estadoNucleo) {
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
        if (!(object instanceof ParObjetivo)) {
            return false;
        }
        ParObjetivo other = (ParObjetivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParObjetivo[ id=" + id + " ]";
    }

    public boolean getEstadoObjetivo() {
        return estadoObjetivo;
    }

    public void setEstadoObjetivo(boolean estadoObjetivo) {
        this.estadoObjetivo = estadoObjetivo;
    }

    @XmlTransient
    public Collection<ParNucleoTematico> getParNucleoTematicoCollection() {
        return parNucleoTematicoCollection;
    }

    public void setParNucleoTematicoCollection(Collection<ParNucleoTematico> parNucleoTematicoCollection) {
        this.parNucleoTematicoCollection = parNucleoTematicoCollection;
    }
    
}
