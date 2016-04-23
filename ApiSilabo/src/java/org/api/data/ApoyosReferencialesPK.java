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
public class ApoyosReferencialesPK implements Serializable {

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
    @Column(name = "version_nro_materia")
    private short versionNroMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_apoyo")
    private String tipoApoyo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_item_ref")
    private short nroItemRef;

    public ApoyosReferencialesPK() {
    }

    public ApoyosReferencialesPK(String codigoMateria, String modalidadMateria, short versionNroMateria, String tipoApoyo, short nroItemRef) {
        this.codigoMateria = codigoMateria;
        this.modalidadMateria = modalidadMateria;
        this.versionNroMateria = versionNroMateria;
        this.tipoApoyo = tipoApoyo;
        this.nroItemRef = nroItemRef;
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

    public short getVersionNroMateria() {
        return versionNroMateria;
    }

    public void setVersionNroMateria(short versionNroMateria) {
        this.versionNroMateria = versionNroMateria;
    }

    public String getTipoApoyo() {
        return tipoApoyo;
    }

    public void setTipoApoyo(String tipoApoyo) {
        this.tipoApoyo = tipoApoyo;
    }

    public short getNroItemRef() {
        return nroItemRef;
    }

    public void setNroItemRef(short nroItemRef) {
        this.nroItemRef = nroItemRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        hash += (modalidadMateria != null ? modalidadMateria.hashCode() : 0);
        hash += (int) versionNroMateria;
        hash += (tipoApoyo != null ? tipoApoyo.hashCode() : 0);
        hash += (int) nroItemRef;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApoyosReferencialesPK)) {
            return false;
        }
        ApoyosReferencialesPK other = (ApoyosReferencialesPK) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if ((this.modalidadMateria == null && other.modalidadMateria != null) || (this.modalidadMateria != null && !this.modalidadMateria.equals(other.modalidadMateria))) {
            return false;
        }
        if (this.versionNroMateria != other.versionNroMateria) {
            return false;
        }
        if ((this.tipoApoyo == null && other.tipoApoyo != null) || (this.tipoApoyo != null && !this.tipoApoyo.equals(other.tipoApoyo))) {
            return false;
        }
        if (this.nroItemRef != other.nroItemRef) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ApoyosReferencialesPK[ codigoMateria=" + codigoMateria + ", modalidadMateria=" + modalidadMateria + ", versionNroMateria=" + versionNroMateria + ", tipoApoyo=" + tipoApoyo + ", nroItemRef=" + nroItemRef + " ]";
    }
    
}
