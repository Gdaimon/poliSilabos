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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByCodigoDpto", query = "SELECT d FROM Departamento d WHERE d.codigoDpto = :codigoDpto"),
    @NamedQuery(name = "Departamento.findBySedeFacultad", query = "SELECT d FROM Departamento d WHERE d.sedeFacultad = :sedeFacultad"),
    @NamedQuery(name = "Departamento.findByNombreFacultad", query = "SELECT d FROM Departamento d WHERE d.nombreFacultad = :nombreFacultad"),
    @NamedQuery(name = "Departamento.findByNombreDpto", query = "SELECT d FROM Departamento d WHERE d.nombreDpto = :nombreDpto")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo_dpto")
    private String codigoDpto;
    @Size(max = 45)
    @Column(name = "sede_facultad")
    private String sedeFacultad;
    @Size(max = 60)
    @Column(name = "nombre_facultad")
    private String nombreFacultad;
    @Size(max = 60)
    @Column(name = "nombre_dpto")
    private String nombreDpto;

    public Departamento() {
    }

    public Departamento(String codigoDpto) {
        this.codigoDpto = codigoDpto;
    }

    public String getCodigoDpto() {
        return codigoDpto;
    }

    public void setCodigoDpto(String codigoDpto) {
        this.codigoDpto = codigoDpto;
    }

    public String getSedeFacultad() {
        return sedeFacultad;
    }

    public void setSedeFacultad(String sedeFacultad) {
        this.sedeFacultad = sedeFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDpto != null ? codigoDpto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.codigoDpto == null && other.codigoDpto != null) || (this.codigoDpto != null && !this.codigoDpto.equals(other.codigoDpto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.Departamento[ codigoDpto=" + codigoDpto + " ]";
    }
    
}
