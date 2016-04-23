/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "apoyos_referenciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApoyosReferenciales.findAll", query = "SELECT a FROM ApoyosReferenciales a"),
    @NamedQuery(name = "ApoyosReferenciales.findByCodigoMateria", query = "SELECT a FROM ApoyosReferenciales a WHERE a.apoyosReferencialesPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "ApoyosReferenciales.findByModalidadMateria", query = "SELECT a FROM ApoyosReferenciales a WHERE a.apoyosReferencialesPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "ApoyosReferenciales.findByVersionNroMateria", query = "SELECT a FROM ApoyosReferenciales a WHERE a.apoyosReferencialesPK.versionNroMateria = :versionNroMateria"),
    @NamedQuery(name = "ApoyosReferenciales.findByTipoApoyo", query = "SELECT a FROM ApoyosReferenciales a WHERE a.apoyosReferencialesPK.tipoApoyo = :tipoApoyo"),
    @NamedQuery(name = "ApoyosReferenciales.findByNroItemRef", query = "SELECT a FROM ApoyosReferenciales a WHERE a.apoyosReferencialesPK.nroItemRef = :nroItemRef"),
    @NamedQuery(name = "ApoyosReferenciales.findByDescripcion", query = "SELECT a FROM ApoyosReferenciales a WHERE a.descripcion = :descripcion")})
public class ApoyosReferenciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApoyosReferencialesPK apoyosReferencialesPK;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;

    public ApoyosReferenciales() {
    }

    public ApoyosReferenciales(ApoyosReferencialesPK apoyosReferencialesPK) {
        this.apoyosReferencialesPK = apoyosReferencialesPK;
    }

    public ApoyosReferenciales(String codigoMateria, String modalidadMateria, short versionNroMateria, String tipoApoyo, short nroItemRef) {
        this.apoyosReferencialesPK = new ApoyosReferencialesPK(codigoMateria, modalidadMateria, versionNroMateria, tipoApoyo, nroItemRef);
    }

    public ApoyosReferencialesPK getApoyosReferencialesPK() {
        return apoyosReferencialesPK;
    }

    public void setApoyosReferencialesPK(ApoyosReferencialesPK apoyosReferencialesPK) {
        this.apoyosReferencialesPK = apoyosReferencialesPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apoyosReferencialesPK != null ? apoyosReferencialesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApoyosReferenciales)) {
            return false;
        }
        ApoyosReferenciales other = (ApoyosReferenciales) object;
        if ((this.apoyosReferencialesPK == null && other.apoyosReferencialesPK != null) || (this.apoyosReferencialesPK != null && !this.apoyosReferencialesPK.equals(other.apoyosReferencialesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ApoyosReferenciales[ apoyosReferencialesPK=" + apoyosReferencialesPK + " ]";
    }
    
}
