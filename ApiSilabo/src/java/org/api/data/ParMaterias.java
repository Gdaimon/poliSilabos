package org.api.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "par_materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParMaterias.findAll", query = "SELECT p FROM ParMaterias p"),
    @NamedQuery(name = "ParMaterias.findById", query = "SELECT p FROM ParMaterias p WHERE p.id = :id"),
    @NamedQuery(name = "ParMaterias.findByCodMateria", query = "SELECT p FROM ParMaterias p WHERE p.codMateria = :codMateria"),
    @NamedQuery(name = "ParMaterias.findByNombre", query = "SELECT p FROM ParMaterias p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ParMaterias.findByDescripcion", query = "SELECT p FROM ParMaterias p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ParMaterias.findByLogro", query = "SELECT p FROM ParMaterias p WHERE p.logro = :logro"),
    @NamedQuery(name = "ParMaterias.findByModalidad", query = "SELECT p FROM ParMaterias p WHERE p.modalidad = :modalidad"),
    @NamedQuery(name = "ParMaterias.findByNoCreditos", query = "SELECT p FROM ParMaterias p WHERE p.noCreditos = :noCreditos"),
    @NamedQuery(name = "ParMaterias.findByDuracion", query = "SELECT p FROM ParMaterias p WHERE p.duracion = :duracion"),
    @NamedQuery(name = "ParMaterias.findByTipoAsignatura", query = "SELECT p FROM ParMaterias p WHERE p.tipoAsignatura = :tipoAsignatura"),
    @NamedQuery(name = "ParMaterias.findByFechaCreacion", query = "SELECT p FROM ParMaterias p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParMaterias.findByEstadoMateria", query = "SELECT p FROM ParMaterias p WHERE p.estadoMateria = :estadoMateria")})
public class ParMaterias implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_materia")
    private int codMateria;
    @JoinTable(name = "par_materia_prerequisito", joinColumns = {
        @JoinColumn(name = "materia", referencedColumnName = "cod_materia")}, inverseJoinColumns = {
        @JoinColumn(name = "materiaprerequisito", referencedColumnName = "cod_materia")})
    @ManyToMany
    private Collection<ParMaterias> parMateriasCollection;
    @ManyToMany(mappedBy = "parMateriasCollection")
    private Collection<ParMaterias> parMateriasCollection1;
    @JoinTable(name = "par_usuario_materia", joinColumns = {
        @JoinColumn(name = "id_materia", referencedColumnName = "cod_materia")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ParUsuarios> parUsuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Collection<ParSilabo> parSilaboCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "logro")
    private String logro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "modalidad")
    private String modalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_creditos")
    private int noCreditos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "duracion")
    private String duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo_asignatura")
    private String tipoAsignatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_materia")
    private boolean estadoMateria;
    @OneToMany(mappedBy = "codMateria")
    private Collection<ParEje> parEjeCollection;
    @OneToMany(mappedBy = "codMateria")
    private Collection<ParNucleoTematico> parNucleoTematicoCollection;
    @OneToMany(mappedBy = "codMateria")
    private Collection<ParTitulo> parTituloCollection;
    @OneToMany(mappedBy = "codMateria")
    private Collection<ParObjetivo> parObjetivoCollection;

    public ParMaterias() {
    }

    public ParMaterias(Integer id) {
        this.id = id;
    }

    public ParMaterias(Integer id, String nombre, String descripcion, String logro, String modalidad, int noCreditos, String duracion, String tipoAsignatura, Date fechaCreacion, boolean estadoMateria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.logro = logro;
        this.modalidad = modalidad;
        this.noCreditos = noCreditos;
        this.duracion = duracion;
        this.tipoAsignatura = tipoAsignatura;
        this.fechaCreacion = fechaCreacion;
        this.estadoMateria = estadoMateria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogro() {
        return logro;
    }

    public void setLogro(String logro) {
        this.logro = logro;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getNoCreditos() {
        return noCreditos;
    }

    public void setNoCreditos(int noCreditos) {
        this.noCreditos = noCreditos;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipoAsignatura() {
        return tipoAsignatura;
    }

    public void setTipoAsignatura(String tipoAsignatura) {
        this.tipoAsignatura = tipoAsignatura;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getEstadoMateria() {
        return estadoMateria;
    }

    public void setEstadoMateria(boolean estadoMateria) {
        this.estadoMateria = estadoMateria;
    }

    @XmlTransient
    public Collection<ParEje> getParEjeCollection() {
        return parEjeCollection;
    }

    public void setParEjeCollection(Collection<ParEje> parEjeCollection) {
        this.parEjeCollection = parEjeCollection;
    }

    @XmlTransient
    public Collection<ParNucleoTematico> getParNucleoTematicoCollection() {
        return parNucleoTematicoCollection;
    }

    public void setParNucleoTematicoCollection(Collection<ParNucleoTematico> parNucleoTematicoCollection) {
        this.parNucleoTematicoCollection = parNucleoTematicoCollection;
    }

    @XmlTransient
    public Collection<ParTitulo> getParTituloCollection() {
        return parTituloCollection;
    }

    public void setParTituloCollection(Collection<ParTitulo> parTituloCollection) {
        this.parTituloCollection = parTituloCollection;
    }

    @XmlTransient
    public Collection<ParObjetivo> getParObjetivoCollection() {
        return parObjetivoCollection;
    }

    public void setParObjetivoCollection(Collection<ParObjetivo> parObjetivoCollection) {
        this.parObjetivoCollection = parObjetivoCollection;
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
        if (!(object instanceof ParMaterias)) {
            return false;
        }
        ParMaterias other = (ParMaterias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParMaterias[ id=" + id + " ]";
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    @XmlTransient
    public Collection<ParMaterias> getParMateriasCollection() {
        return parMateriasCollection;
    }

    public void setParMateriasCollection(Collection<ParMaterias> parMateriasCollection) {
        this.parMateriasCollection = parMateriasCollection;
    }

    @XmlTransient
    public Collection<ParMaterias> getParMateriasCollection1() {
        return parMateriasCollection1;
    }

    public void setParMateriasCollection1(Collection<ParMaterias> parMateriasCollection1) {
        this.parMateriasCollection1 = parMateriasCollection1;
    }

    @XmlTransient
    public Collection<ParUsuarios> getParUsuariosCollection() {
        return parUsuariosCollection;
    }

    public void setParUsuariosCollection(Collection<ParUsuarios> parUsuariosCollection) {
        this.parUsuariosCollection = parUsuariosCollection;
    }

    @XmlTransient
    public Collection<ParSilabo> getParSilaboCollection() {
        return parSilaboCollection;
    }

    public void setParSilaboCollection(Collection<ParSilabo> parSilaboCollection) {
        this.parSilaboCollection = parSilaboCollection;
    }
    
}
