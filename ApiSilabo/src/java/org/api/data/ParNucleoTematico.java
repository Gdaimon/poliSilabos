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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "par_nucleo_tematico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParNucleoTematico.findAll", query = "SELECT p FROM ParNucleoTematico p"),
    @NamedQuery(name = "ParNucleoTematico.findById", query = "SELECT p FROM ParNucleoTematico p WHERE p.id = :id"),
    @NamedQuery(name = "ParNucleoTematico.findByDescripcion", query = "SELECT p FROM ParNucleoTematico p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ParNucleoTematico.findByFechaCreacion", query = "SELECT p FROM ParNucleoTematico p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParNucleoTematico.findByEstadoNucleo", query = "SELECT p FROM ParNucleoTematico p WHERE p.estadoNucleo = :estadoNucleo")})
public class ParNucleoTematico implements Serializable {

    @OneToMany(mappedBy = "idNucleo")
    private Collection<ParNucleoTitulo> parNucleoTituloCollection;
    @OneToMany(mappedBy = "idNucleo")
    private Collection<ParNucleoEje> parNucleoEjeCollection;
    @JoinColumn(name = "id_eje", referencedColumnName = "id")
    @ManyToOne
    private ParEje idEje;
    @JoinColumn(name = "id_objetivo", referencedColumnName = "id")
    @ManyToOne
    private ParObjetivo idObjetivo;
    @JoinColumn(name = "id_titulo", referencedColumnName = "id")
    @ManyToOne
    private ParTitulo idTitulo;
    @OneToMany(mappedBy = "idNucleo")
    private Collection<ParSilaboNucleo> parSilaboNucleoCollection;
    @OneToMany(mappedBy = "idNucleo")
    private Collection<ParNucleoObjetivo> parNucleoObjetivoCollection;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "parNucleoTematicoCollection")
    private Collection<ParEje> parEjeCollection;
    @JoinTable(name = "par_silabo_nucleo", joinColumns = {
        @JoinColumn(name = "nucleotematico", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "silabo", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ParSilabo> parSilaboCollection;
    @JoinTable(name = "par_nucleo_objetivo", joinColumns = {
        @JoinColumn(name = "nucleo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "objetivo", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ParObjetivo> parObjetivoCollection;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<ParEje> getParEjeCollection() {
        return parEjeCollection;
    }

    public void setParEjeCollection(Collection<ParEje> parEjeCollection) {
        this.parEjeCollection = parEjeCollection;
    }

    @XmlTransient
    public Collection<ParSilabo> getParSilaboCollection() {
        return parSilaboCollection;
    }

    public void setParSilaboCollection(Collection<ParSilabo> parSilaboCollection) {
        this.parSilaboCollection = parSilaboCollection;
    }

    @XmlTransient
    public Collection<ParObjetivo> getParObjetivoCollection() {
        return parObjetivoCollection;
    }

    public void setParObjetivoCollection(Collection<ParObjetivo> parObjetivoCollection) {
        this.parObjetivoCollection = parObjetivoCollection;
    }

    @XmlTransient
    public Collection<ParNucleoTitulo> getParNucleoTituloCollection() {
        return parNucleoTituloCollection;
    }

    public void setParNucleoTituloCollection(Collection<ParNucleoTitulo> parNucleoTituloCollection) {
        this.parNucleoTituloCollection = parNucleoTituloCollection;
    }

    @XmlTransient
    public Collection<ParNucleoEje> getParNucleoEjeCollection() {
        return parNucleoEjeCollection;
    }

    public void setParNucleoEjeCollection(Collection<ParNucleoEje> parNucleoEjeCollection) {
        this.parNucleoEjeCollection = parNucleoEjeCollection;
    }

    public ParEje getIdEje() {
        return idEje;
    }

    public void setIdEje(ParEje idEje) {
        this.idEje = idEje;
    }

    public ParObjetivo getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(ParObjetivo idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public ParTitulo getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(ParTitulo idTitulo) {
        this.idTitulo = idTitulo;
    }

    @XmlTransient
    public Collection<ParSilaboNucleo> getParSilaboNucleoCollection() {
        return parSilaboNucleoCollection;
    }

    public void setParSilaboNucleoCollection(Collection<ParSilaboNucleo> parSilaboNucleoCollection) {
        this.parSilaboNucleoCollection = parSilaboNucleoCollection;
    }

    @XmlTransient
    public Collection<ParNucleoObjetivo> getParNucleoObjetivoCollection() {
        return parNucleoObjetivoCollection;
    }

    public void setParNucleoObjetivoCollection(Collection<ParNucleoObjetivo> parNucleoObjetivoCollection) {
        this.parNucleoObjetivoCollection = parNucleoObjetivoCollection;
    }
    
}
