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
public class CompetenciaUsuarioPK implements Serializable {

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
    @Size(min = 1, max = 2)
    @Column(name = "tipo_cedula")
    private String tipoCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula_usuario")
    private long cedulaUsuario;

    public CompetenciaUsuarioPK() {
    }

    public CompetenciaUsuarioPK(String codigoCompetencia, short versionCompetencia, String tipoCedula, long cedulaUsuario) {
        this.codigoCompetencia = codigoCompetencia;
        this.versionCompetencia = versionCompetencia;
        this.tipoCedula = tipoCedula;
        this.cedulaUsuario = cedulaUsuario;
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

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public long getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(long cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCompetencia != null ? codigoCompetencia.hashCode() : 0);
        hash += (int) versionCompetencia;
        hash += (tipoCedula != null ? tipoCedula.hashCode() : 0);
        hash += (int) cedulaUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenciaUsuarioPK)) {
            return false;
        }
        CompetenciaUsuarioPK other = (CompetenciaUsuarioPK) object;
        if ((this.codigoCompetencia == null && other.codigoCompetencia != null) || (this.codigoCompetencia != null && !this.codigoCompetencia.equals(other.codigoCompetencia))) {
            return false;
        }
        if (this.versionCompetencia != other.versionCompetencia) {
            return false;
        }
        if ((this.tipoCedula == null && other.tipoCedula != null) || (this.tipoCedula != null && !this.tipoCedula.equals(other.tipoCedula))) {
            return false;
        }
        if (this.cedulaUsuario != other.cedulaUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.CompetenciaUsuarioPK[ codigoCompetencia=" + codigoCompetencia + ", versionCompetencia=" + versionCompetencia + ", tipoCedula=" + tipoCedula + ", cedulaUsuario=" + cedulaUsuario + " ]";
    }
    
}
