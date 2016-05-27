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
@Table(name = "par_nucleo_objetivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParNucleoObjetivo.findAll", query = "SELECT p FROM ParNucleoObjetivo p"),
    @NamedQuery(name = "ParNucleoObjetivo.findById", query = "SELECT p FROM ParNucleoObjetivo p WHERE p.id = :id")})
public class ParNucleoObjetivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_nucleo", referencedColumnName = "id")
    @ManyToOne
    private ParNucleoTematico idNucleo;
    @JoinColumn(name = "id_objetivo", referencedColumnName = "id")
    @ManyToOne
    private ParObjetivo idObjetivo;

    public ParNucleoObjetivo() {
    }

    public ParNucleoObjetivo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParNucleoTematico getIdNucleo() {
        return idNucleo;
    }

    public void setIdNucleo(ParNucleoTematico idNucleo) {
        this.idNucleo = idNucleo;
    }

    public ParObjetivo getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(ParObjetivo idObjetivo) {
        this.idObjetivo = idObjetivo;
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
        if (!(object instanceof ParNucleoObjetivo)) {
            return false;
        }
        ParNucleoObjetivo other = (ParNucleoObjetivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParNucleoObjetivo[ id=" + id + " ]";
    }
    
}
