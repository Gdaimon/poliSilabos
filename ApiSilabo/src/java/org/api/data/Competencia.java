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
@Table(name = "competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c"),
    @NamedQuery(name = "Competencia.findByCodigoCompetencia", query = "SELECT c FROM Competencia c WHERE c.competenciaPK.codigoCompetencia = :codigoCompetencia"),
    @NamedQuery(name = "Competencia.findByVersionCompetencia", query = "SELECT c FROM Competencia c WHERE c.competenciaPK.versionCompetencia = :versionCompetencia"),
    @NamedQuery(name = "Competencia.findByDescripcionCompetencia", query = "SELECT c FROM Competencia c WHERE c.descripcionCompetencia = :descripcionCompetencia"),
    @NamedQuery(name = "Competencia.findByTipoCedulaOriginante", query = "SELECT c FROM Competencia c WHERE c.tipoCedulaOriginante = :tipoCedulaOriginante"),
    @NamedQuery(name = "Competencia.findByCedulaOriginante", query = "SELECT c FROM Competencia c WHERE c.cedulaOriginante = :cedulaOriginante")})
public class Competencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetenciaPK competenciaPK;
    @Size(max = 500)
    @Column(name = "descripcion_competencia")
    private String descripcionCompetencia;
    @Size(max = 2)
    @Column(name = "tipo_cedula_originante")
    private String tipoCedulaOriginante;
    @Column(name = "cedula_originante")
    private Long cedulaOriginante;

    public Competencia() {
    }

    public Competencia(CompetenciaPK competenciaPK) {
        this.competenciaPK = competenciaPK;
    }

    public Competencia(String codigoCompetencia, short versionCompetencia) {
        this.competenciaPK = new CompetenciaPK(codigoCompetencia, versionCompetencia);
    }

    public CompetenciaPK getCompetenciaPK() {
        return competenciaPK;
    }

    public void setCompetenciaPK(CompetenciaPK competenciaPK) {
        this.competenciaPK = competenciaPK;
    }

    public String getDescripcionCompetencia() {
        return descripcionCompetencia;
    }

    public void setDescripcionCompetencia(String descripcionCompetencia) {
        this.descripcionCompetencia = descripcionCompetencia;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenciaPK != null ? competenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.competenciaPK == null && other.competenciaPK != null) || (this.competenciaPK != null && !this.competenciaPK.equals(other.competenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.Competencia[ competenciaPK=" + competenciaPK + " ]";
    }
    
}
