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
public class MateriasilaboUsuarioPK implements Serializable {

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
    @Size(min = 1, max = 2)
    @Column(name = "tipo_cedula")
    private String tipoCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula_usuario")
    private long cedulaUsuario;

    public MateriasilaboUsuarioPK() {
    }

    public MateriasilaboUsuarioPK(String codigoMateria, String modalidadMateria, String tipoCedula, long cedulaUsuario) {
        this.codigoMateria = codigoMateria;
        this.modalidadMateria = modalidadMateria;
        this.tipoCedula = tipoCedula;
        this.cedulaUsuario = cedulaUsuario;
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
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        hash += (modalidadMateria != null ? modalidadMateria.hashCode() : 0);
        hash += (tipoCedula != null ? tipoCedula.hashCode() : 0);
        hash += (int) cedulaUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriasilaboUsuarioPK)) {
            return false;
        }
        MateriasilaboUsuarioPK other = (MateriasilaboUsuarioPK) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        if ((this.modalidadMateria == null && other.modalidadMateria != null) || (this.modalidadMateria != null && !this.modalidadMateria.equals(other.modalidadMateria))) {
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
        return "org.api.data.MateriasilaboUsuarioPK[ codigoMateria=" + codigoMateria + ", modalidadMateria=" + modalidadMateria + ", tipoCedula=" + tipoCedula + ", cedulaUsuario=" + cedulaUsuario + " ]";
    }
    
}
