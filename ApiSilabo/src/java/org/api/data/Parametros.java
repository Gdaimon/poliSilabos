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
@Table(name = "parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p"),
    @NamedQuery(name = "Parametros.findByCodigoparametro", query = "SELECT p FROM Parametros p WHERE p.parametrosPK.codigoparametro = :codigoparametro"),
    @NamedQuery(name = "Parametros.findByItemparametro", query = "SELECT p FROM Parametros p WHERE p.parametrosPK.itemparametro = :itemparametro"),
    @NamedQuery(name = "Parametros.findByNombreParametro", query = "SELECT p FROM Parametros p WHERE p.nombreParametro = :nombreParametro"),
    @NamedQuery(name = "Parametros.findByTipoParametro", query = "SELECT p FROM Parametros p WHERE p.tipoParametro = :tipoParametro"),
    @NamedQuery(name = "Parametros.findByDescripcionParametro", query = "SELECT p FROM Parametros p WHERE p.descripcionParametro = :descripcionParametro")})
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParametrosPK parametrosPK;
    @Size(max = 50)
    @Column(name = "nombre_parametro")
    private String nombreParametro;
    @Size(max = 10)
    @Column(name = "tipo_parametro")
    private String tipoParametro;
    @Size(max = 60)
    @Column(name = "descripcion_parametro")
    private String descripcionParametro;

    public Parametros() {
    }

    public Parametros(ParametrosPK parametrosPK) {
        this.parametrosPK = parametrosPK;
    }

    public Parametros(String codigoparametro, short itemparametro) {
        this.parametrosPK = new ParametrosPK(codigoparametro, itemparametro);
    }

    public ParametrosPK getParametrosPK() {
        return parametrosPK;
    }

    public void setParametrosPK(ParametrosPK parametrosPK) {
        this.parametrosPK = parametrosPK;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(String tipoParametro) {
        this.tipoParametro = tipoParametro;
    }

    public String getDescripcionParametro() {
        return descripcionParametro;
    }

    public void setDescripcionParametro(String descripcionParametro) {
        this.descripcionParametro = descripcionParametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parametrosPK != null ? parametrosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.parametrosPK == null && other.parametrosPK != null) || (this.parametrosPK != null && !this.parametrosPK.equals(other.parametrosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.Parametros[ parametrosPK=" + parametrosPK + " ]";
    }
    
}
