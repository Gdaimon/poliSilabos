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
public class UsuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_cedula")
    private String tipoCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula_usuario")
    private long cedulaUsuario;

    public UsuarioPK() {
    }

    public UsuarioPK(String tipoCedula, long cedulaUsuario) {
        this.tipoCedula = tipoCedula;
        this.cedulaUsuario = cedulaUsuario;
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
        hash += (tipoCedula != null ? tipoCedula.hashCode() : 0);
        hash += (int) cedulaUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
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
        return "org.api.data.UsuarioPK[ tipoCedula=" + tipoCedula + ", cedulaUsuario=" + cedulaUsuario + " ]";
    }
    
}
