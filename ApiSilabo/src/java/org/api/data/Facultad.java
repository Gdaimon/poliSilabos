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
@Table(name = "facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    @NamedQuery(name = "Facultad.findBySedeFacultad", query = "SELECT f FROM Facultad f WHERE f.facultadPK.sedeFacultad = :sedeFacultad"),
    @NamedQuery(name = "Facultad.findByNombreFacultad", query = "SELECT f FROM Facultad f WHERE f.facultadPK.nombreFacultad = :nombreFacultad")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacultadPK facultadPK;

    public Facultad() {
    }

    public Facultad(FacultadPK facultadPK) {
        this.facultadPK = facultadPK;
    }

    public Facultad(String sedeFacultad, String nombreFacultad) {
        this.facultadPK = new FacultadPK(sedeFacultad, nombreFacultad);
    }

    public FacultadPK getFacultadPK() {
        return facultadPK;
    }

    public void setFacultadPK(FacultadPK facultadPK) {
        this.facultadPK = facultadPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultadPK != null ? facultadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.facultadPK == null && other.facultadPK != null) || (this.facultadPK != null && !this.facultadPK.equals(other.facultadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.Facultad[ facultadPK=" + facultadPK + " ]";
    }
    
}
