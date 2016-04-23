/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "competencia_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetenciaUsuario.findAll", query = "SELECT c FROM CompetenciaUsuario c"),
    @NamedQuery(name = "CompetenciaUsuario.findByCodigoCompetencia", query = "SELECT c FROM CompetenciaUsuario c WHERE c.competenciaUsuarioPK.codigoCompetencia = :codigoCompetencia"),
    @NamedQuery(name = "CompetenciaUsuario.findByVersionCompetencia", query = "SELECT c FROM CompetenciaUsuario c WHERE c.competenciaUsuarioPK.versionCompetencia = :versionCompetencia"),
    @NamedQuery(name = "CompetenciaUsuario.findByTipoCedula", query = "SELECT c FROM CompetenciaUsuario c WHERE c.competenciaUsuarioPK.tipoCedula = :tipoCedula"),
    @NamedQuery(name = "CompetenciaUsuario.findByCedulaUsuario", query = "SELECT c FROM CompetenciaUsuario c WHERE c.competenciaUsuarioPK.cedulaUsuario = :cedulaUsuario")})
public class CompetenciaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetenciaUsuarioPK competenciaUsuarioPK;

    public CompetenciaUsuario() {
    }

    public CompetenciaUsuario(CompetenciaUsuarioPK competenciaUsuarioPK) {
        this.competenciaUsuarioPK = competenciaUsuarioPK;
    }

    public CompetenciaUsuario(String codigoCompetencia, short versionCompetencia, String tipoCedula, long cedulaUsuario) {
        this.competenciaUsuarioPK = new CompetenciaUsuarioPK(codigoCompetencia, versionCompetencia, tipoCedula, cedulaUsuario);
    }

    public CompetenciaUsuarioPK getCompetenciaUsuarioPK() {
        return competenciaUsuarioPK;
    }

    public void setCompetenciaUsuarioPK(CompetenciaUsuarioPK competenciaUsuarioPK) {
        this.competenciaUsuarioPK = competenciaUsuarioPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenciaUsuarioPK != null ? competenciaUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenciaUsuario)) {
            return false;
        }
        CompetenciaUsuario other = (CompetenciaUsuario) object;
        if ((this.competenciaUsuarioPK == null && other.competenciaUsuarioPK != null) || (this.competenciaUsuarioPK != null && !this.competenciaUsuarioPK.equals(other.competenciaUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.CompetenciaUsuario[ competenciaUsuarioPK=" + competenciaUsuarioPK + " ]";
    }
    
}
