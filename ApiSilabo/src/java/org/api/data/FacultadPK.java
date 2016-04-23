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
public class FacultadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sede_facultad")
    private String sedeFacultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_facultad")
    private String nombreFacultad;

    public FacultadPK() {
    }

    public FacultadPK(String sedeFacultad, String nombreFacultad) {
        this.sedeFacultad = sedeFacultad;
        this.nombreFacultad = nombreFacultad;
    }

    public String getSedeFacultad() {
        return sedeFacultad;
    }

    public void setSedeFacultad(String sedeFacultad) {
        this.sedeFacultad = sedeFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sedeFacultad != null ? sedeFacultad.hashCode() : 0);
        hash += (nombreFacultad != null ? nombreFacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacultadPK)) {
            return false;
        }
        FacultadPK other = (FacultadPK) object;
        if ((this.sedeFacultad == null && other.sedeFacultad != null) || (this.sedeFacultad != null && !this.sedeFacultad.equals(other.sedeFacultad))) {
            return false;
        }
        if ((this.nombreFacultad == null && other.nombreFacultad != null) || (this.nombreFacultad != null && !this.nombreFacultad.equals(other.nombreFacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.FacultadPK[ sedeFacultad=" + sedeFacultad + ", nombreFacultad=" + nombreFacultad + " ]";
    }
    
}
