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
@Table(name = "nucleo_tematico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NucleoTematico.findAll", query = "SELECT n FROM NucleoTematico n"),
    @NamedQuery(name = "NucleoTematico.findByCodigoMateria", query = "SELECT n FROM NucleoTematico n WHERE n.nucleoTematicoPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "NucleoTematico.findByModalidadMateria", query = "SELECT n FROM NucleoTematico n WHERE n.nucleoTematicoPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "NucleoTematico.findByVersionNroMateria", query = "SELECT n FROM NucleoTematico n WHERE n.nucleoTematicoPK.versionNroMateria = :versionNroMateria"),
    @NamedQuery(name = "NucleoTematico.findByNroTematico", query = "SELECT n FROM NucleoTematico n WHERE n.nucleoTematicoPK.nroTematico = :nroTematico"),
    @NamedQuery(name = "NucleoTematico.findByNroItemTem", query = "SELECT n FROM NucleoTematico n WHERE n.nucleoTematicoPK.nroItemTem = :nroItemTem"),
    @NamedQuery(name = "NucleoTematico.findByDescripcionNucleoTematico", query = "SELECT n FROM NucleoTematico n WHERE n.descripcionNucleoTematico = :descripcionNucleoTematico"),
    @NamedQuery(name = "NucleoTematico.findByEjesTematicos", query = "SELECT n FROM NucleoTematico n WHERE n.ejesTematicos = :ejesTematicos"),
    @NamedQuery(name = "NucleoTematico.findByObjetivoespecifico", query = "SELECT n FROM NucleoTematico n WHERE n.objetivoespecifico = :objetivoespecifico")})
public class NucleoTematico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NucleoTematicoPK nucleoTematicoPK;
    @Size(max = 100)
    @Column(name = "descripcion_nucleo_tematico")
    private String descripcionNucleoTematico;
    @Size(max = 1500)
    @Column(name = "ejes_tematicos")
    private String ejesTematicos;
    @Size(max = 1000)
    @Column(name = "objetivoespecifico")
    private String objetivoespecifico;

    public NucleoTematico() {
    }

    public NucleoTematico(NucleoTematicoPK nucleoTematicoPK) {
        this.nucleoTematicoPK = nucleoTematicoPK;
    }

    public NucleoTematico(String codigoMateria, String modalidadMateria, short versionNroMateria, short nroTematico, short nroItemTem) {
        this.nucleoTematicoPK = new NucleoTematicoPK(codigoMateria, modalidadMateria, versionNroMateria, nroTematico, nroItemTem);
    }

    public NucleoTematicoPK getNucleoTematicoPK() {
        return nucleoTematicoPK;
    }

    public void setNucleoTematicoPK(NucleoTematicoPK nucleoTematicoPK) {
        this.nucleoTematicoPK = nucleoTematicoPK;
    }

    public String getDescripcionNucleoTematico() {
        return descripcionNucleoTematico;
    }

    public void setDescripcionNucleoTematico(String descripcionNucleoTematico) {
        this.descripcionNucleoTematico = descripcionNucleoTematico;
    }

    public String getEjesTematicos() {
        return ejesTematicos;
    }

    public void setEjesTematicos(String ejesTematicos) {
        this.ejesTematicos = ejesTematicos;
    }

    public String getObjetivoespecifico() {
        return objetivoespecifico;
    }

    public void setObjetivoespecifico(String objetivoespecifico) {
        this.objetivoespecifico = objetivoespecifico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nucleoTematicoPK != null ? nucleoTematicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NucleoTematico)) {
            return false;
        }
        NucleoTematico other = (NucleoTematico) object;
        if ((this.nucleoTematicoPK == null && other.nucleoTematicoPK != null) || (this.nucleoTematicoPK != null && !this.nucleoTematicoPK.equals(other.nucleoTematicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.NucleoTematico[ nucleoTematicoPK=" + nucleoTematicoPK + " ]";
    }
    
}
