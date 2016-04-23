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
@Table(name = "descripciones_generales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionesGenerales.findAll", query = "SELECT d FROM DescripcionesGenerales d"),
    @NamedQuery(name = "DescripcionesGenerales.findByCodigoMateria", query = "SELECT d FROM DescripcionesGenerales d WHERE d.descripcionesGeneralesPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "DescripcionesGenerales.findByModalidadMateria", query = "SELECT d FROM DescripcionesGenerales d WHERE d.descripcionesGeneralesPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "DescripcionesGenerales.findByVersionNroMateria", query = "SELECT d FROM DescripcionesGenerales d WHERE d.descripcionesGeneralesPK.versionNroMateria = :versionNroMateria"),
    @NamedQuery(name = "DescripcionesGenerales.findByTipoDescripcion", query = "SELECT d FROM DescripcionesGenerales d WHERE d.descripcionesGeneralesPK.tipoDescripcion = :tipoDescripcion"),
    @NamedQuery(name = "DescripcionesGenerales.findByDescripcion", query = "SELECT d FROM DescripcionesGenerales d WHERE d.descripcion = :descripcion")})
public class DescripcionesGenerales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DescripcionesGeneralesPK descripcionesGeneralesPK;
    @Size(max = 1600)
    @Column(name = "descripcion")
    private String descripcion;

    public DescripcionesGenerales() {
    }

    public DescripcionesGenerales(DescripcionesGeneralesPK descripcionesGeneralesPK) {
        this.descripcionesGeneralesPK = descripcionesGeneralesPK;
    }

    public DescripcionesGenerales(String codigoMateria, String modalidadMateria, short versionNroMateria, String tipoDescripcion) {
        this.descripcionesGeneralesPK = new DescripcionesGeneralesPK(codigoMateria, modalidadMateria, versionNroMateria, tipoDescripcion);
    }

    public DescripcionesGeneralesPK getDescripcionesGeneralesPK() {
        return descripcionesGeneralesPK;
    }

    public void setDescripcionesGeneralesPK(DescripcionesGeneralesPK descripcionesGeneralesPK) {
        this.descripcionesGeneralesPK = descripcionesGeneralesPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descripcionesGeneralesPK != null ? descripcionesGeneralesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionesGenerales)) {
            return false;
        }
        DescripcionesGenerales other = (DescripcionesGenerales) object;
        if ((this.descripcionesGeneralesPK == null && other.descripcionesGeneralesPK != null) || (this.descripcionesGeneralesPK != null && !this.descripcionesGeneralesPK.equals(other.descripcionesGeneralesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.DescripcionesGenerales[ descripcionesGeneralesPK=" + descripcionesGeneralesPK + " ]";
    }
    
}
