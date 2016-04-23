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
@Table(name = "contiene_competecia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContieneCompetecia.findAll", query = "SELECT c FROM ContieneCompetecia c"),
    @NamedQuery(name = "ContieneCompetecia.findByCodigoCompetencia", query = "SELECT c FROM ContieneCompetecia c WHERE c.contieneCompeteciaPK.codigoCompetencia = :codigoCompetencia"),
    @NamedQuery(name = "ContieneCompetecia.findByVersionCompetencia", query = "SELECT c FROM ContieneCompetecia c WHERE c.contieneCompeteciaPK.versionCompetencia = :versionCompetencia"),
    @NamedQuery(name = "ContieneCompetecia.findByCodigoMateria", query = "SELECT c FROM ContieneCompetecia c WHERE c.contieneCompeteciaPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "ContieneCompetecia.findByModalidadMateria", query = "SELECT c FROM ContieneCompetecia c WHERE c.contieneCompeteciaPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "ContieneCompetecia.findByVersionNroMateria", query = "SELECT c FROM ContieneCompetecia c WHERE c.contieneCompeteciaPK.versionNroMateria = :versionNroMateria")})
public class ContieneCompetecia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContieneCompeteciaPK contieneCompeteciaPK;

    public ContieneCompetecia() {
    }

    public ContieneCompetecia(ContieneCompeteciaPK contieneCompeteciaPK) {
        this.contieneCompeteciaPK = contieneCompeteciaPK;
    }

    public ContieneCompetecia(String codigoCompetencia, short versionCompetencia, String codigoMateria, String modalidadMateria, short versionNroMateria) {
        this.contieneCompeteciaPK = new ContieneCompeteciaPK(codigoCompetencia, versionCompetencia, codigoMateria, modalidadMateria, versionNroMateria);
    }

    public ContieneCompeteciaPK getContieneCompeteciaPK() {
        return contieneCompeteciaPK;
    }

    public void setContieneCompeteciaPK(ContieneCompeteciaPK contieneCompeteciaPK) {
        this.contieneCompeteciaPK = contieneCompeteciaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contieneCompeteciaPK != null ? contieneCompeteciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContieneCompetecia)) {
            return false;
        }
        ContieneCompetecia other = (ContieneCompetecia) object;
        if ((this.contieneCompeteciaPK == null && other.contieneCompeteciaPK != null) || (this.contieneCompeteciaPK != null && !this.contieneCompeteciaPK.equals(other.contieneCompeteciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ContieneCompetecia[ contieneCompeteciaPK=" + contieneCompeteciaPK + " ]";
    }
    
}
