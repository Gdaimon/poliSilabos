/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "silabo_histo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SilaboHisto.findAll", query = "SELECT s FROM SilaboHisto s"),
    @NamedQuery(name = "SilaboHisto.findByCodigoMateria", query = "SELECT s FROM SilaboHisto s WHERE s.silaboHistoPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "SilaboHisto.findByModalidadMateria", query = "SELECT s FROM SilaboHisto s WHERE s.silaboHistoPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "SilaboHisto.findByVersionSilabo", query = "SELECT s FROM SilaboHisto s WHERE s.silaboHistoPK.versionSilabo = :versionSilabo"),
    @NamedQuery(name = "SilaboHisto.findByCodigoFormato", query = "SELECT s FROM SilaboHisto s WHERE s.codigoFormato = :codigoFormato"),
    @NamedQuery(name = "SilaboHisto.findByVigenciaDesdeSilabo", query = "SELECT s FROM SilaboHisto s WHERE s.vigenciaDesdeSilabo = :vigenciaDesdeSilabo")})
public class SilaboHisto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SilaboHistoPK silaboHistoPK;
    @Size(max = 20)
    @Column(name = "codigo_formato")
    private String codigoFormato;
    @Column(name = "vigencia_desde_silabo")
    @Temporal(TemporalType.DATE)
    private Date vigenciaDesdeSilabo;

    public SilaboHisto() {
    }

    public SilaboHisto(SilaboHistoPK silaboHistoPK) {
        this.silaboHistoPK = silaboHistoPK;
    }

    public SilaboHisto(String codigoMateria, String modalidadMateria, String versionSilabo) {
        this.silaboHistoPK = new SilaboHistoPK(codigoMateria, modalidadMateria, versionSilabo);
    }

    public SilaboHistoPK getSilaboHistoPK() {
        return silaboHistoPK;
    }

    public void setSilaboHistoPK(SilaboHistoPK silaboHistoPK) {
        this.silaboHistoPK = silaboHistoPK;
    }

    public String getCodigoFormato() {
        return codigoFormato;
    }

    public void setCodigoFormato(String codigoFormato) {
        this.codigoFormato = codigoFormato;
    }

    public Date getVigenciaDesdeSilabo() {
        return vigenciaDesdeSilabo;
    }

    public void setVigenciaDesdeSilabo(Date vigenciaDesdeSilabo) {
        this.vigenciaDesdeSilabo = vigenciaDesdeSilabo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (silaboHistoPK != null ? silaboHistoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SilaboHisto)) {
            return false;
        }
        SilaboHisto other = (SilaboHisto) object;
        if ((this.silaboHistoPK == null && other.silaboHistoPK != null) || (this.silaboHistoPK != null && !this.silaboHistoPK.equals(other.silaboHistoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.SilaboHisto[ silaboHistoPK=" + silaboHistoPK + " ]";
    }
    
}
