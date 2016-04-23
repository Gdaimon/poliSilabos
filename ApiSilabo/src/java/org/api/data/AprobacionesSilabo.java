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
@Table(name = "aprobaciones_silabo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AprobacionesSilabo.findAll", query = "SELECT a FROM AprobacionesSilabo a"),
    @NamedQuery(name = "AprobacionesSilabo.findByCodigoMateria", query = "SELECT a FROM AprobacionesSilabo a WHERE a.aprobacionesSilaboPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "AprobacionesSilabo.findByModalidadMateria", query = "SELECT a FROM AprobacionesSilabo a WHERE a.aprobacionesSilaboPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "AprobacionesSilabo.findByVersionNroMateria", query = "SELECT a FROM AprobacionesSilabo a WHERE a.aprobacionesSilaboPK.versionNroMateria = :versionNroMateria"),
    @NamedQuery(name = "AprobacionesSilabo.findByCedulaAprobador", query = "SELECT a FROM AprobacionesSilabo a WHERE a.aprobacionesSilaboPK.cedulaAprobador = :cedulaAprobador"),
    @NamedQuery(name = "AprobacionesSilabo.findByTipoCedulaAprobador", query = "SELECT a FROM AprobacionesSilabo a WHERE a.aprobacionesSilaboPK.tipoCedulaAprobador = :tipoCedulaAprobador"),
    @NamedQuery(name = "AprobacionesSilabo.findByNombreAprobador", query = "SELECT a FROM AprobacionesSilabo a WHERE a.nombreAprobador = :nombreAprobador"),
    @NamedQuery(name = "AprobacionesSilabo.findByApellidoAprobador", query = "SELECT a FROM AprobacionesSilabo a WHERE a.apellidoAprobador = :apellidoAprobador"),
    @NamedQuery(name = "AprobacionesSilabo.findByNroAprobador", query = "SELECT a FROM AprobacionesSilabo a WHERE a.nroAprobador = :nroAprobador"),
    @NamedQuery(name = "AprobacionesSilabo.findByFechaAprobo", query = "SELECT a FROM AprobacionesSilabo a WHERE a.fechaAprobo = :fechaAprobo")})
public class AprobacionesSilabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AprobacionesSilaboPK aprobacionesSilaboPK;
    @Size(max = 20)
    @Column(name = "nombre_aprobador")
    private String nombreAprobador;
    @Size(max = 20)
    @Column(name = "apellido_aprobador")
    private String apellidoAprobador;
    @Size(max = 10)
    @Column(name = "nro_aprobador")
    private String nroAprobador;
    @Column(name = "fecha_aprobo")
    @Temporal(TemporalType.DATE)
    private Date fechaAprobo;

    public AprobacionesSilabo() {
    }

    public AprobacionesSilabo(AprobacionesSilaboPK aprobacionesSilaboPK) {
        this.aprobacionesSilaboPK = aprobacionesSilaboPK;
    }

    public AprobacionesSilabo(String codigoMateria, String modalidadMateria, short versionNroMateria, String cedulaAprobador, String tipoCedulaAprobador) {
        this.aprobacionesSilaboPK = new AprobacionesSilaboPK(codigoMateria, modalidadMateria, versionNroMateria, cedulaAprobador, tipoCedulaAprobador);
    }

    public AprobacionesSilaboPK getAprobacionesSilaboPK() {
        return aprobacionesSilaboPK;
    }

    public void setAprobacionesSilaboPK(AprobacionesSilaboPK aprobacionesSilaboPK) {
        this.aprobacionesSilaboPK = aprobacionesSilaboPK;
    }

    public String getNombreAprobador() {
        return nombreAprobador;
    }

    public void setNombreAprobador(String nombreAprobador) {
        this.nombreAprobador = nombreAprobador;
    }

    public String getApellidoAprobador() {
        return apellidoAprobador;
    }

    public void setApellidoAprobador(String apellidoAprobador) {
        this.apellidoAprobador = apellidoAprobador;
    }

    public String getNroAprobador() {
        return nroAprobador;
    }

    public void setNroAprobador(String nroAprobador) {
        this.nroAprobador = nroAprobador;
    }

    public Date getFechaAprobo() {
        return fechaAprobo;
    }

    public void setFechaAprobo(Date fechaAprobo) {
        this.fechaAprobo = fechaAprobo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aprobacionesSilaboPK != null ? aprobacionesSilaboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AprobacionesSilabo)) {
            return false;
        }
        AprobacionesSilabo other = (AprobacionesSilabo) object;
        if ((this.aprobacionesSilaboPK == null && other.aprobacionesSilaboPK != null) || (this.aprobacionesSilaboPK != null && !this.aprobacionesSilaboPK.equals(other.aprobacionesSilaboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.AprobacionesSilabo[ aprobacionesSilaboPK=" + aprobacionesSilaboPK + " ]";
    }
    
}
