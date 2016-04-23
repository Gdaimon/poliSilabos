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
public class NucleoTematicoPK implements Serializable {

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
    @Column(name = "nro_tematico")
    private short nroTematico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_item_tem")
    private short nroItemTem;

    public NucleoTematicoPK() {
    }

    public NucleoTematicoPK(String codigoMateria, String modalidadMateria, short versionNroMateria, short nroTematico, short nroItemTem) {
        this.codigoMateria = codigoMateria;
        this.modalidadMateria = modalidadMateria;
        this.versionNroMateria = versionNroMateria;
        this.nroTematico = nroTematico;
        this.nroItemTem = nroItemTem;
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

    public short getNroTematico() {
        return nroTematico;
    }

    public void setNroTematico(short nroTematico) {
        this.nroTematico = nroTematico;
    }

    public short getNroItemTem() {
        return nroItemTem;
    }

    public void setNroItemTem(short nroItemTem) {
        this.nroItemTem = nroItemTem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        hash += (modalidadMateria != null ? modalidadMateria.hashCode() : 0);
        hash += (int) versionNroMateria;
        hash += (int) nroTematico;
        hash += (int) nroItemTem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NucleoTematicoPK)) {
            return false;
        }
        NucleoTematicoPK other = (NucleoTematicoPK) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if ((this.modalidadMateria == null && other.modalidadMateria != null) || (this.modalidadMateria != null && !this.modalidadMateria.equals(other.modalidadMateria))) {
            return false;
        }
        if (this.versionNroMateria != other.versionNroMateria) {
            return false;
        }
        if (this.nroTematico != other.nroTematico) {
            return false;
        }
        if (this.nroItemTem != other.nroItemTem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.NucleoTematicoPK[ codigoMateria=" + codigoMateria + ", modalidadMateria=" + modalidadMateria + ", versionNroMateria=" + versionNroMateria + ", nroTematico=" + nroTematico + ", nroItemTem=" + nroItemTem + " ]";
    }
    
}
