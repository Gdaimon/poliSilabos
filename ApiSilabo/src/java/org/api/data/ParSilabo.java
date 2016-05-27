/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gdaimon
 */
@Entity
@Table(name = "par_silabo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParSilabo.findAll", query = "SELECT p FROM ParSilabo p"),
    @NamedQuery(name = "ParSilabo.findById", query = "SELECT p FROM ParSilabo p WHERE p.id = :id"),
    @NamedQuery(name = "ParSilabo.findByDesarrollodidactico", query = "SELECT p FROM ParSilabo p WHERE p.desarrollodidactico = :desarrollodidactico"),
    @NamedQuery(name = "ParSilabo.findByEvaluacion", query = "SELECT p FROM ParSilabo p WHERE p.evaluacion = :evaluacion"),
    @NamedQuery(name = "ParSilabo.findByApoyosreferenciales", query = "SELECT p FROM ParSilabo p WHERE p.apoyosreferenciales = :apoyosreferenciales")})
public class ParSilabo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "desarrollo_didactico")
    private String desarrolloDidactico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "apoyos_referenciales")
    private String apoyosReferenciales;
    @Size(max = 2147483647)
    @Column(name = "apoyo_audiovisual")
    private String apoyoAudiovisual;
    @Size(max = 2147483647)
    @Column(name = "otros_apoyos")
    private String otrosApoyos;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id")
    @ManyToOne
    private ParCompetencia idCompetencia;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ParDepartamento idDepartamento;
    @JoinColumn(name = "id_materia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ParMaterias idMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSilabo")
    private Collection<ParSilaboNucleo> parSilaboNucleoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "desarrollodidactico")
    private String desarrollodidactico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "evaluacion")
    private String evaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "apoyosreferenciales")
    private String apoyosreferenciales;
    @ManyToMany(mappedBy = "parSilaboCollection")
    private Collection<ParCompetencia> parCompetenciaCollection;
    @ManyToMany(mappedBy = "parSilaboCollection")
    private Collection<ParNucleoTematico> parNucleoTematicoCollection;
    @JoinColumn(name = "departamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ParDepartamento departamento;
    @JoinColumn(name = "materia", referencedColumnName = "cod_materia")
    @ManyToOne(optional = false)
    private ParMaterias materia;

    public ParSilabo() {
    }

    public ParSilabo(Integer id) {
        this.id = id;
    }

    public ParSilabo(Integer id, String desarrollodidactico, String evaluacion, String apoyosreferenciales) {
        this.id = id;
        this.desarrollodidactico = desarrollodidactico;
        this.evaluacion = evaluacion;
        this.apoyosreferenciales = apoyosreferenciales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesarrollodidactico() {
        return desarrollodidactico;
    }

    public void setDesarrollodidactico(String desarrollodidactico) {
        this.desarrollodidactico = desarrollodidactico;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getApoyosreferenciales() {
        return apoyosreferenciales;
    }

    public void setApoyosreferenciales(String apoyosreferenciales) {
        this.apoyosreferenciales = apoyosreferenciales;
    }

    @XmlTransient
    public Collection<ParCompetencia> getParCompetenciaCollection() {
        return parCompetenciaCollection;
    }

    public void setParCompetenciaCollection(Collection<ParCompetencia> parCompetenciaCollection) {
        this.parCompetenciaCollection = parCompetenciaCollection;
    }

    @XmlTransient
    public Collection<ParNucleoTematico> getParNucleoTematicoCollection() {
        return parNucleoTematicoCollection;
    }

    public void setParNucleoTematicoCollection(Collection<ParNucleoTematico> parNucleoTematicoCollection) {
        this.parNucleoTematicoCollection = parNucleoTematicoCollection;
    }

    public ParDepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(ParDepartamento departamento) {
        this.departamento = departamento;
    }

    public ParMaterias getMateria() {
        return materia;
    }

    public void setMateria(ParMaterias materia) {
        this.materia = materia;
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
        if (!(object instanceof ParSilabo)) {
            return false;
        }
        ParSilabo other = (ParSilabo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParSilabo[ id=" + id + " ]";
    }

    public String getDesarrolloDidactico() {
        return desarrolloDidactico;
    }

    public void setDesarrolloDidactico(String desarrolloDidactico) {
        this.desarrolloDidactico = desarrolloDidactico;
    }

    public String getApoyosReferenciales() {
        return apoyosReferenciales;
    }

    public void setApoyosReferenciales(String apoyosReferenciales) {
        this.apoyosReferenciales = apoyosReferenciales;
    }

    public String getApoyoAudiovisual() {
        return apoyoAudiovisual;
    }

    public void setApoyoAudiovisual(String apoyoAudiovisual) {
        this.apoyoAudiovisual = apoyoAudiovisual;
    }

    public String getOtrosApoyos() {
        return otrosApoyos;
    }

    public void setOtrosApoyos(String otrosApoyos) {
        this.otrosApoyos = otrosApoyos;
    }

    public ParCompetencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(ParCompetencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public ParDepartamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(ParDepartamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public ParMaterias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(ParMaterias idMateria) {
        this.idMateria = idMateria;
    }

    @XmlTransient
    public Collection<ParSilaboNucleo> getParSilaboNucleoCollection() {
        return parSilaboNucleoCollection;
    }

    public void setParSilaboNucleoCollection(Collection<ParSilaboNucleo> parSilaboNucleoCollection) {
        this.parSilaboNucleoCollection = parSilaboNucleoCollection;
    }
    
}
