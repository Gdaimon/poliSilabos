/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cod_materia")
    private Integer codMateria;
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
    private List<ParEje> parEjeList;
    @JoinColumn(name = "id_creador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ParUsuarios idCreador;
    @OneToMany(mappedBy = "codMateria")
    private List<ParNucleoTematico> parNucleoTematicoList;
    @OneToMany(mappedBy = "codMateria")
    private List<ParTitulo> parTituloList;
    @OneToMany(mappedBy = "codMateria")
    private List<ParObjetivo> parObjetivoList;

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
    public List<ParEje> getParEjeList() {
        return parEjeList;
    }

    public void setParEjeList(List<ParEje> parEjeList) {
        this.parEjeList = parEjeList;
    }

    public ParUsuarios getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(ParUsuarios idCreador) {
        this.idCreador = idCreador;
    }

    @XmlTransient
    public List<ParNucleoTematico> getParNucleoTematicoList() {
        return parNucleoTematicoList;
    }

    public void setParNucleoTematicoList(List<ParNucleoTematico> parNucleoTematicoList) {
        this.parNucleoTematicoList = parNucleoTematicoList;
    }

    @XmlTransient
    public List<ParTitulo> getParTituloList() {
        return parTituloList;
    }

    public void setParTituloList(List<ParTitulo> parTituloList) {
        this.parTituloList = parTituloList;
    }

    @XmlTransient
    public List<ParObjetivo> getParObjetivoList() {
        return parObjetivoList;
    }

    public void setParObjetivoList(List<ParObjetivo> parObjetivoList) {
        this.parObjetivoList = parObjetivoList;
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
    
}
