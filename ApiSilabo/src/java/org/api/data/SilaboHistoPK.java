/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DarkKlitos
 */
@Embeddable
public class SilaboHistoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo_materia")
    private String codigoMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "modalidad_materia")
    private String modalidadMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "version_silabo")
    private String versionSilabo;

    public SilaboHistoPK() {
    }

    public SilaboHistoPK(String codigoMateria, String modalidadMateria, String versionSilabo) {
        this.codigoMateria = codigoMateria;
        this.modalidadMateria = modalidadMateria;
        this.versionSilabo = versionSilabo;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getModalidadMateria() {
        return modalidadMateria;
    }

    public void setModalidadMateria(String modalidadMateria) {
        this.modalidadMateria = modalidadMateria;
    }

    public String getVersionSilabo() {
        return versionSilabo;
    }

    public void setVersionSilabo(String versionSilabo) {
        this.versionSilabo = versionSilabo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        hash += (modalidadMateria != null ? modalidadMateria.hashCode() : 0);
        hash += (versionSilabo != null ? versionSilabo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SilaboHistoPK)) {
            return false;
        }
        SilaboHistoPK other = (SilaboHistoPK) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if ((this.modalidadMateria == null && other.modalidadMateria != null) || (this.modalidadMateria != null && !this.modalidadMateria.equals(other.modalidadMateria))) {
            return false;
        }
        if ((this.versionSilabo == null && other.versionSilabo != null) || (this.versionSilabo != null && !this.versionSilabo.equals(other.versionSilabo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.SilaboHistoPK[ codigoMateria=" + codigoMateria + ", modalidadMateria=" + modalidadMateria + ", versionSilabo=" + versionSilabo + " ]";
    }
    
}
