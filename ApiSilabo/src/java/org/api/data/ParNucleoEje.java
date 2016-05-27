/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "par_nucleo_eje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParNucleoEje.findAll", query = "SELECT p FROM ParNucleoEje p"),
    @NamedQuery(name = "ParNucleoEje.findById", query = "SELECT p FROM ParNucleoEje p WHERE p.id = :id")})
public class ParNucleoEje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_eje", referencedColumnName = "id")
    @ManyToOne
    private ParEje idEje;
    @JoinColumn(name = "id_nucleo", referencedColumnName = "id")
    @ManyToOne
    private ParNucleoTematico idNucleo;

    public ParNucleoEje() {
    }

    public ParNucleoEje(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParEje getIdEje() {
        return idEje;
    }

    public void setIdEje(ParEje idEje) {
        this.idEje = idEje;
    }

    public ParNucleoTematico getIdNucleo() {
        return idNucleo;
    }

    public void setIdNucleo(ParNucleoTematico idNucleo) {
        this.idNucleo = idNucleo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParNucleoEje)) {
            return false;
        }
        ParNucleoEje other = (ParNucleoEje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParNucleoEje[ id=" + id + " ]";
    }
    
}
