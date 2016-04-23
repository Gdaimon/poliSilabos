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
@Table(name = "materiasilabo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriasilaboUsuario.findAll", query = "SELECT m FROM MateriasilaboUsuario m"),
    @NamedQuery(name = "MateriasilaboUsuario.findByCodigoMateria", query = "SELECT m FROM MateriasilaboUsuario m WHERE m.materiasilaboUsuarioPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "MateriasilaboUsuario.findByModalidadMateria", query = "SELECT m FROM MateriasilaboUsuario m WHERE m.materiasilaboUsuarioPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "MateriasilaboUsuario.findByTipoCedula", query = "SELECT m FROM MateriasilaboUsuario m WHERE m.materiasilaboUsuarioPK.tipoCedula = :tipoCedula"),
    @NamedQuery(name = "MateriasilaboUsuario.findByCedulaUsuario", query = "SELECT m FROM MateriasilaboUsuario m WHERE m.materiasilaboUsuarioPK.cedulaUsuario = :cedulaUsuario")})
public class MateriasilaboUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriasilaboUsuarioPK materiasilaboUsuarioPK;

    public MateriasilaboUsuario() {
    }

    public MateriasilaboUsuario(MateriasilaboUsuarioPK materiasilaboUsuarioPK) {
        this.materiasilaboUsuarioPK = materiasilaboUsuarioPK;
    }

    public MateriasilaboUsuario(String codigoMateria, String modalidadMateria, String tipoCedula, long cedulaUsuario) {
        this.materiasilaboUsuarioPK = new MateriasilaboUsuarioPK(codigoMateria, modalidadMateria, tipoCedula, cedulaUsuario);
    }

    public MateriasilaboUsuarioPK getMateriasilaboUsuarioPK() {
        return materiasilaboUsuarioPK;
    }

    public void setMateriasilaboUsuarioPK(MateriasilaboUsuarioPK materiasilaboUsuarioPK) {
        this.materiasilaboUsuarioPK = materiasilaboUsuarioPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiasilaboUsuarioPK != null ? materiasilaboUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriasilaboUsuario)) {
            return false;
        }
        MateriasilaboUsuario other = (MateriasilaboUsuario) object;
        if ((this.materiasilaboUsuarioPK == null && other.materiasilaboUsuarioPK != null) || (this.materiasilaboUsuarioPK != null && !this.materiasilaboUsuarioPK.equals(other.materiasilaboUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.MateriasilaboUsuario[ materiasilaboUsuarioPK=" + materiasilaboUsuarioPK + " ]";
    }
    
}
