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
@Table(name = "par_nucleo_titulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParNucleoTitulo.findAll", query = "SELECT p FROM ParNucleoTitulo p"),
    @NamedQuery(name = "ParNucleoTitulo.findById", query = "SELECT p FROM ParNucleoTitulo p WHERE p.id = :id")})
public class ParNucleoTitulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_nucleo", referencedColumnName = "id")
    @ManyToOne
    private ParNucleoTematico idNucleo;
    @JoinColumn(name = "id_titulo", referencedColumnName = "id")
    @ManyToOne
    private ParTitulo idTitulo;

    public ParNucleoTitulo() {
    }

    public ParNucleoTitulo(Integer id) {
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

    public ParTitulo getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(ParTitulo idTitulo) {
        this.idTitulo = idTitulo;
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
        if (!(object instanceof ParNucleoTitulo)) {
            return false;
        }
        ParNucleoTitulo other = (ParNucleoTitulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParNucleoTitulo[ id=" + id + " ]";
    }
    
}
