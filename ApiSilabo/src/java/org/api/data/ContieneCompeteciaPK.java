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
public class ContieneCompeteciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_competencia")
    private String codigoCompetencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version_competencia")
    private short versionCompetencia;
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

    public ContieneCompeteciaPK() {
    }

    public ContieneCompeteciaPK(String codigoCompetencia, short versionCompetencia, String codigoMateria, String modalidadMateria, short versionNroMateria) {
        this.codigoCompetencia = codigoCompetencia;
        this.versionCompetencia = versionCompetencia;
        this.codigoMateria = codigoMateria;
        this.modalidadMateria = modalidadMateria;
        this.versionNroMateria = versionNroMateria;
    }

    public String getCodigoCompetencia() {
        return codigoCompetencia;
    }

    public void setCodigoCompetencia(String codigoCompetencia) {
        this.codigoCompetencia = codigoCompetencia;
    }

    public short getVersionCompetencia() {
        return versionCompetencia;
    }

    public void setVersionCompetencia(short versionCompetencia) {
        this.versionCompetencia = versionCompetencia;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCompetencia != null ? codigoCompetencia.hashCode() : 0);
        hash += (int) versionCompetencia;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        hash += (modalidadMateria != null ? modalidadMateria.hashCode() : 0);
        hash += (int) versionNroMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContieneCompeteciaPK)) {
            return false;
        }
        ContieneCompeteciaPK other = (ContieneCompeteciaPK) object;
        if ((this.codigoCompetencia == null && other.codigoCompetencia != null) || (this.codigoCompetencia != null && !this.codigoCompetencia.equals(other.codigoCompetencia))) {
            return false;
        }
        if (this.versionCompetencia != other.versionCompetencia) {
            return false;
        }
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if ((this.modalidadMateria == null && other.modalidadMateria != null) || (this.modalidadMateria != null && !this.modalidadMateria.equals(other.modalidadMateria))) {
            return false;
        }
        if (this.versionNroMateria != other.versionNroMateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ContieneCompeteciaPK[ codigoCompetencia=" + codigoCompetencia + ", versionCompetencia=" + versionCompetencia + ", codigoMateria=" + codigoMateria + ", modalidadMateria=" + modalidadMateria + ", versionNroMateria=" + versionNroMateria + " ]";
    }
    
}
