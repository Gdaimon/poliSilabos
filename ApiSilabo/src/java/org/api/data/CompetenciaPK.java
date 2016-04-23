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
public class CompetenciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_competencia")
    private String codigoCompetencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version_competencia")
    private short versionCompetencia;

    public CompetenciaPK() {
    }

    public CompetenciaPK(String codigoCompetencia, short versionCompetencia) {
        this.codigoCompetencia = codigoCompetencia;
        this.versionCompetencia = versionCompetencia;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCompetencia != null ? codigoCompetencia.hashCode() : 0);
        hash += (int) versionCompetencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenciaPK)) {
            return false;
        }
        CompetenciaPK other = (CompetenciaPK) object;
        if ((this.codigoCompetencia == null && other.codigoCompetencia != null) || (this.codigoCompetencia != null && !this.codigoCompetencia.equals(other.codigoCompetencia))) {
            return false;
        }
        if (this.versionCompetencia != other.versionCompetencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.CompetenciaPK[ codigoCompetencia=" + codigoCompetencia + ", versionCompetencia=" + versionCompetencia + " ]";
    }
    
}
