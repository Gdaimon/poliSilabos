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
@Table(name = "prerequisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prerequisito.findAll", query = "SELECT p FROM Prerequisito p"),
    @NamedQuery(name = "Prerequisito.findByCodigoMateria", query = "SELECT p FROM Prerequisito p WHERE p.prerequisitoPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "Prerequisito.findByModalidadMateria", query = "SELECT p FROM Prerequisito p WHERE p.prerequisitoPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "Prerequisito.findByVersionNroMateria", query = "SELECT p FROM Prerequisito p WHERE p.prerequisitoPK.versionNroMateria = :versionNroMateria"),
    @NamedQuery(name = "Prerequisito.findByCodigoMateriaPre", query = "SELECT p FROM Prerequisito p WHERE p.prerequisitoPK.codigoMateriaPre = :codigoMateriaPre")})
public class Prerequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrerequisitoPK prerequisitoPK;

    public Prerequisito() {
    }

    public Prerequisito(PrerequisitoPK prerequisitoPK) {
        this.prerequisitoPK = prerequisitoPK;
    }

    public Prerequisito(String codigoMateria, String modalidadMateria, short versionNroMateria, String codigoMateriaPre) {
        this.prerequisitoPK = new PrerequisitoPK(codigoMateria, modalidadMateria, versionNroMateria, codigoMateriaPre);
    }

    public PrerequisitoPK getPrerequisitoPK() {
        return prerequisitoPK;
    }

    public void setPrerequisitoPK(PrerequisitoPK prerequisitoPK) {
        this.prerequisitoPK = prerequisitoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prerequisitoPK != null ? prerequisitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prerequisito)) {
            return false;
        }
        Prerequisito other = (Prerequisito) object;
        if ((this.prerequisitoPK == null && other.prerequisitoPK != null) || (this.prerequisitoPK != null && !this.prerequisitoPK.equals(other.prerequisitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.Prerequisito[ prerequisitoPK=" + prerequisitoPK + " ]";
    }
    
}
