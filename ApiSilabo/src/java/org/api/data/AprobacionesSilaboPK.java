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
public class AprobacionesSilaboPK implements Serializable {

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
    @Column(name = "cedula_aprobador")
    private String cedulaAprobador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo_cedula_aprobador")
    private String tipoCedulaAprobador;

    public AprobacionesSilaboPK() {
    }

    public AprobacionesSilaboPK(String codigoMateria, String modalidadMateria, short versionNroMateria, String cedulaAprobador, String tipoCedulaAprobador) {
        this.codigoMateria = codigoMateria;
        this.modalidadMateria = modalidadMateria;
        this.versionNroMateria = versionNroMateria;
        this.cedulaAprobador = cedulaAprobador;
        this.tipoCedulaAprobador = tipoCedulaAprobador;
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

    public String getCedulaAprobador() {
        return cedulaAprobador;
    }

    public void setCedulaAprobador(String cedulaAprobador) {
        this.cedulaAprobador = cedulaAprobador;
    }

    public String getTipoCedulaAprobador() {
        return tipoCedulaAprobador;
    }

    public void setTipoCedulaAprobador(String tipoCedulaAprobador) {
        this.tipoCedulaAprobador = tipoCedulaAprobador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        hash += (modalidadMateria != null ? modalidadMateria.hashCode() : 0);
        hash += (int) versionNroMateria;
        hash += (cedulaAprobador != null ? cedulaAprobador.hashCode() : 0);
        hash += (tipoCedulaAprobador != null ? tipoCedulaAprobador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AprobacionesSilaboPK)) {
            return false;
        }
        AprobacionesSilaboPK other = (AprobacionesSilaboPK) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if ((this.modalidadMateria == null && other.modalidadMateria != null) || (this.modalidadMateria != null && !this.modalidadMateria.equals(other.modalidadMateria))) {
            return false;
        }
        if (this.versionNroMateria != other.versionNroMateria) {
            return false;
        }
        if ((this.cedulaAprobador == null && other.cedulaAprobador != null) || (this.cedulaAprobador != null && !this.cedulaAprobador.equals(other.cedulaAprobador))) {
            return false;
        }
        if ((this.tipoCedulaAprobador == null && other.tipoCedulaAprobador != null) || (this.tipoCedulaAprobador != null && !this.tipoCedulaAprobador.equals(other.tipoCedulaAprobador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.AprobacionesSilaboPK[ codigoMateria=" + codigoMateria + ", modalidadMateria=" + modalidadMateria + ", versionNroMateria=" + versionNroMateria + ", cedulaAprobador=" + cedulaAprobador + ", tipoCedulaAprobador=" + tipoCedulaAprobador + " ]";
    }
    
}
