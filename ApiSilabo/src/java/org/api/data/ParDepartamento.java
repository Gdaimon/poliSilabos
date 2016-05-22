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
@Table(name = "par_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParDepartamento.findById", query = "SELECT p FROM ParDepartamento p WHERE p.id = :id"),
    @NamedQuery(name = "ParDepartamento.findByNombreDepartamento", query = "SELECT p FROM ParDepartamento p WHERE p.nombreDepartamento = :nombreDepartamento"),
    @NamedQuery(name = "ParDepartamento.findByCiudadDepartamento", query = "SELECT p FROM ParDepartamento p WHERE p.ciudadDepartamento = :ciudadDepartamento"),
    @NamedQuery(name = "ParDepartamento.findByFechaCreacion", query = "SELECT p FROM ParDepartamento p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParDepartamento.findByEstadoDepartamento", query = "SELECT p FROM ParDepartamento p WHERE p.estadoDepartamento = :estadoDepartamento"),
    @NamedQuery(name = "ParDepartamento.findAll", query =   "SELECT dep.id, dep.nombreDepartamento, dep.ciudadDepartamento," +
                                                            "       fac.nombreFacultad, dep.estadoDepartamento" +
                                                            "  FROM ParDepartamento dep" +
                                                            "  JOIN dep.idFacultad fac"),
    @NamedQuery(name = "ParDepartamento.findByParams", query = "SELECT p" +
                                                               "  FROM ParDepartamento p" +
                                                               "  WHERE lower(p.nombreDepartamento) like :parametro" +
                                                               "     OR lower(p.ciudadDepartamento) like :parametro")})
public class ParDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_departamento")
    private String nombreDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ciudad_departamento")
    private String ciudadDepartamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_departamento")
    private boolean estadoDepartamento;
    @JoinColumn(name = "id_facultad", referencedColumnName = "id")
    @ManyToOne
    private ParFacultad idFacultad;

    public ParDepartamento() {
    }

    public ParDepartamento(Integer id) {
        this.id = id;
    }

    public ParDepartamento(Integer id, String nombreDepartamento, String ciudadDepartamento, Date fechaCreacion, boolean estadoDepartamento) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
        this.ciudadDepartamento = ciudadDepartamento;
        this.fechaCreacion = fechaCreacion;
        this.estadoDepartamento = estadoDepartamento;
    }

        public ParDepartamento(Integer idFacultad, String nombreDepartamento, String ciudadDepartamento, boolean estadoDepartamento, Date fechaCreacion) {
        this.idFacultad.setId(idFacultad);
        this.nombreDepartamento = nombreDepartamento;
        this.ciudadDepartamento = ciudadDepartamento;
        this.fechaCreacion = fechaCreacion;
        this.estadoDepartamento = estadoDepartamento;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getCiudadDepartamento() {
        return ciudadDepartamento;
    }

    public void setCiudadDepartamento(String ciudadDepartamento) {
        this.ciudadDepartamento = ciudadDepartamento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getEstadoDepartamento() {
        return estadoDepartamento;
    }

    public void setEstadoDepartamento(boolean estadoDepartamento) {
        this.estadoDepartamento = estadoDepartamento;
    }

    public ParFacultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(ParFacultad idFacultad) {
        this.idFacultad = idFacultad;
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
        if (!(object instanceof ParDepartamento)) {
            return false;
        }
        ParDepartamento other = (ParDepartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParDepartamento[ id=" + id + " ]";
    }
    
}
