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
@Table(name = "materia_silabo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaSilabo.findAll", query = "SELECT m FROM MateriaSilabo m"),
    @NamedQuery(name = "MateriaSilabo.findByCodigoMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.materiaSilaboPK.codigoMateria = :codigoMateria"),
    @NamedQuery(name = "MateriaSilabo.findByModalidadMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.materiaSilaboPK.modalidadMateria = :modalidadMateria"),
    @NamedQuery(name = "MateriaSilabo.findByVersionNroMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.materiaSilaboPK.versionNroMateria = :versionNroMateria"),
    @NamedQuery(name = "MateriaSilabo.findByCreditosMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.creditosMateria = :creditosMateria"),
    @NamedQuery(name = "MateriaSilabo.findByBloque", query = "SELECT m FROM MateriaSilabo m WHERE m.bloque = :bloque"),
    @NamedQuery(name = "MateriaSilabo.findByTipoMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.tipoMateria = :tipoMateria"),
    @NamedQuery(name = "MateriaSilabo.findByTipolog\u00edaModulo", query = "SELECT m FROM MateriaSilabo m WHERE m.tipolog\u00edaModulo = :tipolog\u00edaModulo"),
    @NamedQuery(name = "MateriaSilabo.findByVigenciaDesdeMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.vigenciaDesdeMateria = :vigenciaDesdeMateria"),
    @NamedQuery(name = "MateriaSilabo.findByEstadoMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.estadoMateria = :estadoMateria"),
    @NamedQuery(name = "MateriaSilabo.findByDuracionMateria", query = "SELECT m FROM MateriaSilabo m WHERE m.duracionMateria = :duracionMateria"),
    @NamedQuery(name = "MateriaSilabo.findByObservacionesModificacion", query = "SELECT m FROM MateriaSilabo m WHERE m.observacionesModificacion = :observacionesModificacion"),
    @NamedQuery(name = "MateriaSilabo.findByTipoCedulaOriginante", query = "SELECT m FROM MateriaSilabo m WHERE m.tipoCedulaOriginante = :tipoCedulaOriginante"),
    @NamedQuery(name = "MateriaSilabo.findByCedulaOriginante", query = "SELECT m FROM MateriaSilabo m WHERE m.cedulaOriginante = :cedulaOriginante"),
    @NamedQuery(name = "MateriaSilabo.findByCodigoDpto", query = "SELECT m FROM MateriaSilabo m WHERE m.codigoDpto = :codigoDpto")})
public class MateriaSilabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaSilaboPK materiaSilaboPK;
    @Column(name = "creditos_materia")
    private Short creditosMateria;
    @Size(max = 15)
    @Column(name = "bloque")
    private String bloque;
    @Size(max = 20)
    @Column(name = "tipo_materia")
    private String tipoMateria;
    @Size(max = 10)
    @Column(name = "tipolog\u00eda_modulo")
    private String tipologíaModulo;
    @Column(name = "vigencia_desde_materia")
    @Temporal(TemporalType.DATE)
    private Date vigenciaDesdeMateria;
    @Size(max = 10)
    @Column(name = "estado_materia")
    private String estadoMateria;
    @Column(name = "duracion_materia")
    private Short duracionMateria;
    @Size(max = 150)
    @Column(name = "observaciones_modificacion")
    private String observacionesModificacion;
    @Size(max = 2)
    @Column(name = "tipo_cedula_originante")
    private String tipoCedulaOriginante;
    @Column(name = "cedula_originante")
    private Long cedulaOriginante;
    @Size(max = 3)
    @Column(name = "codigo_dpto")
    private String codigoDpto;

    public MateriaSilabo() {
    }

    public MateriaSilabo(MateriaSilaboPK materiaSilaboPK) {
        this.materiaSilaboPK = materiaSilaboPK;
    }

    public MateriaSilabo(String codigoMateria, String modalidadMateria, short versionNroMateria) {
        this.materiaSilaboPK = new MateriaSilaboPK(codigoMateria, modalidadMateria, versionNroMateria);
    }

    public MateriaSilaboPK getMateriaSilaboPK() {
        return materiaSilaboPK;
    }

    public void setMateriaSilaboPK(MateriaSilaboPK materiaSilaboPK) {
        this.materiaSilaboPK = materiaSilaboPK;
    }

    public Short getCreditosMateria() {
        return creditosMateria;
    }

    public void setCreditosMateria(Short creditosMateria) {
        this.creditosMateria = creditosMateria;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(String tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    public String getTipologíaModulo() {
        return tipologíaModulo;
    }

    public void setTipologíaModulo(String tipologíaModulo) {
        this.tipologíaModulo = tipologíaModulo;
    }

    public Date getVigenciaDesdeMateria() {
        return vigenciaDesdeMateria;
    }

    public void setVigenciaDesdeMateria(Date vigenciaDesdeMateria) {
        this.vigenciaDesdeMateria = vigenciaDesdeMateria;
    }

    public String getEstadoMateria() {
        return estadoMateria;
    }

    public void setEstadoMateria(String estadoMateria) {
        this.estadoMateria = estadoMateria;
    }

    public Short getDuracionMateria() {
        return duracionMateria;
    }

    public void setDuracionMateria(Short duracionMateria) {
        this.duracionMateria = duracionMateria;
    }

    public String getObservacionesModificacion() {
        return observacionesModificacion;
    }

    public void setObservacionesModificacion(String observacionesModificacion) {
        this.observacionesModificacion = observacionesModificacion;
    }

    public String getTipoCedulaOriginante() {
        return tipoCedulaOriginante;
    }

    public void setTipoCedulaOriginante(String tipoCedulaOriginante) {
        this.tipoCedulaOriginante = tipoCedulaOriginante;
    }

    public Long getCedulaOriginante() {
        return cedulaOriginante;
    }

    public void setCedulaOriginante(Long cedulaOriginante) {
        this.cedulaOriginante = cedulaOriginante;
    }

    public String getCodigoDpto() {
        return codigoDpto;
    }

    public void setCodigoDpto(String codigoDpto) {
        this.codigoDpto = codigoDpto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaSilaboPK != null ? materiaSilaboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaSilabo)) {
            return false;
        }
        MateriaSilabo other = (MateriaSilabo) object;
        if ((this.materiaSilaboPK == null && other.materiaSilaboPK != null) || (this.materiaSilaboPK != null && !this.materiaSilaboPK.equals(other.materiaSilaboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.MateriaSilabo[ materiaSilaboPK=" + materiaSilaboPK + " ]";
    }
    
}
