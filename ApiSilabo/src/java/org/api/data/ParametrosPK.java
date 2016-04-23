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
public class ParametrosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigoparametro")
    private String codigoparametro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemparametro")
    private short itemparametro;

    public ParametrosPK() {
    }

    public ParametrosPK(String codigoparametro, short itemparametro) {
        this.codigoparametro = codigoparametro;
        this.itemparametro = itemparametro;
    }

    public String getCodigoparametro() {
        return codigoparametro;
    }

    public void setCodigoparametro(String codigoparametro) {
        this.codigoparametro = codigoparametro;
    }

    public short getItemparametro() {
        return itemparametro;
    }

    public void setItemparametro(short itemparametro) {
        this.itemparametro = itemparametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoparametro != null ? codigoparametro.hashCode() : 0);
        hash += (int) itemparametro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrosPK)) {
            return false;
        }
        ParametrosPK other = (ParametrosPK) object;
        if ((this.codigoparametro == null && other.codigoparametro != null) || (this.codigoparametro != null && !this.codigoparametro.equals(other.codigoparametro))) {
            return false;
        }
        if (this.itemparametro != other.itemparametro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParametrosPK[ codigoparametro=" + codigoparametro + ", itemparametro=" + itemparametro + " ]";
    }
    
}
