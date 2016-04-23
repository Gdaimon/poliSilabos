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
@Table(name = "observaciones_silabo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionesSilabo.findAll", query = "SELECT o FROM ObservacionesSilabo o"),
    @NamedQuery(name = "ObservacionesSilabo.findByCodigoMateria", query = "SELECT o FROM ObservacionesSilabo o WHERE o.observacionesSilaboPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "ObservacionesSilabo.findByModalidadMateria", query = "SELECT o FROM ObservacionesSilabo o WHERE o.observacionesSilaboPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "ObservacionesSilabo.findByVersionNroMateria", query = "SELECT o FROM ObservacionesSilabo o WHERE o.observacionesSilaboPK.versionNroMateria = :versionNroMateria"),
    @NamedQuery(name = "ObservacionesSilabo.findByTipoCedulaObservacion", query = "SELECT o FROM ObservacionesSilabo o WHERE o.observacionesSilaboPK.tipoCedulaObservacion = :tipoCedulaObservacion"),
    @NamedQuery(name = "ObservacionesSilabo.findByCedulaObservacion", query = "SELECT o FROM ObservacionesSilabo o WHERE o.observacionesSilaboPK.cedulaObservacion = :cedulaObservacion"),
    @NamedQuery(name = "ObservacionesSilabo.findByNombreObservacion", query = "SELECT o FROM ObservacionesSilabo o WHERE o.nombreObservacion = :nombreObservacion"),
    @NamedQuery(name = "ObservacionesSilabo.findByApellidoObservacion", query = "SELECT o FROM ObservacionesSilabo o WHERE o.apellidoObservacion = :apellidoObservacion"),
    @NamedQuery(name = "ObservacionesSilabo.findByDescripcionObservacion", query = "SELECT o FROM ObservacionesSilabo o WHERE o.descripcionObservacion = :descripcionObservacion"),
    @NamedQuery(name = "ObservacionesSilabo.findByEstadoObservacion", query = "SELECT o FROM ObservacionesSilabo o WHERE o.estadoObservacion = :estadoObservacion")})
public class ObservacionesSilabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservacionesSilaboPK observacionesSilaboPK;
    @Size(max = 20)
    @Column(name = "nombre_observacion")
    private String nombreObservacion;
    @Size(max = 20)
    @Column(name = "apellido_observacion")
    private String apellidoObservacion;
    @Size(max = 200)
    @Column(name = "descripcion_observacion")
    private String descripcionObservacion;
    @Size(max = 15)
    @Column(name = "estado_observacion")
    private String estadoObservacion;

    public ObservacionesSilabo() {
    }

    public ObservacionesSilabo(ObservacionesSilaboPK observacionesSilaboPK) {
        this.observacionesSilaboPK = observacionesSilaboPK;
    }

    public ObservacionesSilabo(String codigoMateria, String modalidadMateria, short versionNroMateria, String tipoCedulaObservacion, String cedulaObservacion) {
        this.observacionesSilaboPK = new ObservacionesSilaboPK(codigoMateria, modalidadMateria, versionNroMateria, tipoCedulaObservacion, cedulaObservacion);
    }

    public ObservacionesSilaboPK getObservacionesSilaboPK() {
        return observacionesSilaboPK;
    }

    public void setObservacionesSilaboPK(ObservacionesSilaboPK observacionesSilaboPK) {
        this.observacionesSilaboPK = observacionesSilaboPK;
    }

    public String getNombreObservacion() {
        return nombreObservacion;
    }

    public void setNombreObservacion(String nombreObservacion) {
        this.nombreObservacion = nombreObservacion;
    }

    public String getApellidoObservacion() {
        return apellidoObservacion;
    }

    public void setApellidoObservacion(String apellidoObservacion) {
        this.apellidoObservacion = apellidoObservacion;
    }

    public String getDescripcionObservacion() {
        return descripcionObservacion;
    }

    public void setDescripcionObservacion(String descripcionObservacion) {
        this.descripcionObservacion = descripcionObservacion;
    }

    public String getEstadoObservacion() {
        return estadoObservacion;
    }

    public void setEstadoObservacion(String estadoObservacion) {
        this.estadoObservacion = estadoObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacionesSilaboPK != null ? observacionesSilaboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionesSilabo)) {
            return false;
        }
        ObservacionesSilabo other = (ObservacionesSilabo) object;
        if ((this.observacionesSilaboPK == null && other.observacionesSilaboPK != null) || (this.observacionesSilaboPK != null && !this.observacionesSilaboPK.equals(other.observacionesSilaboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ObservacionesSilabo[ observacionesSilaboPK=" + observacionesSilaboPK + " ]";
    }
    
}
