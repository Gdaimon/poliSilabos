/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "seccion_silabo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeccionSilabo.findAll", query = "SELECT s FROM SeccionSilabo s"),
    @NamedQuery(name = "SeccionSilabo.findByCodigoMateria", query = "SELECT s FROM SeccionSilabo s WHERE s.seccionSilaboPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "SeccionSilabo.findByModalidadMateria", query = "SELECT s FROM SeccionSilabo s WHERE s.seccionSilaboPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "SeccionSilabo.findByVersionSilabo", query = "SELECT s FROM SeccionSilabo s WHERE s.seccionSilaboPK.versionSilabo = :versionSilabo"),
    @NamedQuery(name = "SeccionSilabo.findByNroSeccionSilabo", query = "SELECT s FROM SeccionSilabo s WHERE s.seccionSilaboPK.nroSeccionSilabo = :nroSeccionSilabo"),
    @NamedQuery(name = "SeccionSilabo.findByNroItemSilabo", query = "SELECT s FROM SeccionSilabo s WHERE s.seccionSilaboPK.nroItemSilabo = :nroItemSilabo"),
    @NamedQuery(name = "SeccionSilabo.findByDescripcionSeccionSilabo", query = "SELECT s FROM SeccionSilabo s WHERE s.descripcionSeccionSilabo = :descripcionSeccionSilabo")})
public class SeccionSilabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeccionSilaboPK seccionSilaboPK;
    @Size(max = 1600)
    @Column(name = "descripcion_seccion_silabo")
    private String descripcionSeccionSilabo;

    public SeccionSilabo() {
    }

    public SeccionSilabo(SeccionSilaboPK seccionSilaboPK) {
        this.seccionSilaboPK = seccionSilaboPK;
    }

    public SeccionSilabo(String codigoMateria, String modalidadMateria, String versionSilabo, String nroSeccionSilabo, short nroItemSilabo) {
        this.seccionSilaboPK = new SeccionSilaboPK(codigoMateria, modalidadMateria, versionSilabo, nroSeccionSilabo, nroItemSilabo);
    }

    public SeccionSilaboPK getSeccionSilaboPK() {
        return seccionSilaboPK;
    }

    public void setSeccionSilaboPK(SeccionSilaboPK seccionSilaboPK) {
        this.seccionSilaboPK = seccionSilaboPK;
    }

    public String getDescripcionSeccionSilabo() {
        return descripcionSeccionSilabo;
    }

    public void setDescripcionSeccionSilabo(String descripcionSeccionSilabo) {
        this.descripcionSeccionSilabo = descripcionSeccionSilabo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seccionSilaboPK != null ? seccionSilaboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeccionSilabo)) {
            return false;
        }
        SeccionSilabo other = (SeccionSilabo) object;
        if ((this.seccionSilaboPK == null && other.seccionSilaboPK != null) || (this.seccionSilaboPK != null && !this.seccionSilaboPK.equals(other.seccionSilaboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.SeccionSilabo[ seccionSilaboPK=" + seccionSilaboPK + " ]";
    }
    
}
