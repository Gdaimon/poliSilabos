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
public class ObservacionesSilaboPK implements Serializable {

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
    @Size(min = 1, max = 10)
    @Column(name = "tipo_cedula_observacion")
    private String tipoCedulaObservacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula_observacion")
    private String cedulaObservacion;

    public ObservacionesSilaboPK() {
    }

    public ObservacionesSilaboPK(String codigoMateria, String modalidadMateria, short versionNroMateria, String tipoCedulaObservacion, String cedulaObservacion) {
        this.codigoMateria = codigoMateria;
        this.modalidadMateria = modalidadMateria;
        this.versionNroMateria = versionNroMateria;
        this.tipoCedulaObservacion = tipoCedulaObservacion;
        this.cedulaObservacion = cedulaObservacion;
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

    public String getTipoCedulaObservacion() {
        return tipoCedulaObservacion;
    }

    public void setTipoCedulaObservacion(String tipoCedulaObservacion) {
        this.tipoCedulaObservacion = tipoCedulaObservacion;
    }

    public String getCedulaObservacion() {
        return cedulaObservacion;
    }

    public void setCedulaObservacion(String cedulaObservacion) {
        this.cedulaObservacion = cedulaObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        hash += (modalidadMateria != null ? modalidadMateria.hashCode() : 0);
        hash += (int) versionNroMateria;
        hash += (tipoCedulaObservacion != null ? tipoCedulaObservacion.hashCode() : 0);
        hash += (cedulaObservacion != null ? cedulaObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionesSilaboPK)) {
            return false;
        }
        ObservacionesSilaboPK other = (ObservacionesSilaboPK) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if ((this.modalidadMateria == null && other.modalidadMateria != null) || (this.modalidadMateria != null && !this.modalidadMateria.equals(other.modalidadMateria))) {
            return false;
        }
        if (this.versionNroMateria != other.versionNroMateria) {
            return false;
        }
        if ((this.tipoCedulaObservacion == null && other.tipoCedulaObservacion != null) || (this.tipoCedulaObservacion != null && !this.tipoCedulaObservacion.equals(other.tipoCedulaObservacion))) {
            return false;
        }
        if ((this.cedulaObservacion == null && other.cedulaObservacion != null) || (this.cedulaObservacion != null && !this.cedulaObservacion.equals(other.cedulaObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ObservacionesSilaboPK[ codigoMateria=" + codigoMateria + ", modalidadMateria=" + modalidadMateria + ", versionNroMateria=" + versionNroMateria + ", tipoCedulaObservacion=" + tipoCedulaObservacion + ", cedulaObservacion=" + cedulaObservacion + " ]";
    }
    
}
