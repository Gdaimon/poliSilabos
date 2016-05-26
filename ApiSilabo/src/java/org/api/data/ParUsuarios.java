package org.api.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "par_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParUsuarios.findAll", query = "SELECT p FROM ParUsuarios p"),
    @NamedQuery(name = "ParUsuarios.findById", query = "SELECT p FROM ParUsuarios p WHERE p.id = :id"),
    @NamedQuery(name = "ParUsuarios.findByIdUsuario", query = "SELECT p FROM ParUsuarios p WHERE p.idUsuario = :idUsuario"),
    @NamedQuery(name = "ParUsuarios.findByTipoCedula", query = "SELECT p FROM ParUsuarios p WHERE p.tipoCedula = :tipoCedula"),
    @NamedQuery(name = "ParUsuarios.findByNombre", query = "SELECT p FROM ParUsuarios p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ParUsuarios.findByApellido", query = "SELECT p FROM ParUsuarios p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "ParUsuarios.findByEmail", query = "SELECT p FROM ParUsuarios p WHERE p.email = :email"),
    @NamedQuery(name = "ParUsuarios.findByPassword", query = "SELECT p FROM ParUsuarios p WHERE p.password = :password"),
    @NamedQuery(name = "ParUsuarios.findByPerfil", query = "SELECT p FROM ParUsuarios p WHERE p.perfil = :perfil"),
    @NamedQuery(name = "ParUsuarios.findByFechaCreacion", query = "SELECT p FROM ParUsuarios p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParUsuarios.findByEstadoUsuario", query = "SELECT p FROM ParUsuarios p WHERE p.estadoUsuario = :estadoUsuario")})
public class ParUsuarios implements Serializable {

    @ManyToMany(mappedBy = "parUsuariosCollection")
    private Collection<ParMaterias> parMateriasCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo_cedula")
    private String tipoCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "apellido")
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "perfil")
    private int perfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_usuario")
    private boolean estadoUsuario;

    public ParUsuarios() {
    }

    public ParUsuarios(Integer id) {
        this.id = id;
    }

    public ParUsuarios(Integer id, String tipoCedula, String nombre, String apellido, String email, String password, int perfil, Date fechaCreacion, boolean estadoUsuario) {
        this.id = id;
        this.tipoCedula = tipoCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.perfil = perfil;
        this.fechaCreacion = fechaCreacion;
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
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
        if (!(object instanceof ParUsuarios)) {
            return false;
        }
        ParUsuarios other = (ParUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParUsuarios[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ParMaterias> getParMateriasCollection() {
        return parMateriasCollection;
    }

    public void setParMateriasCollection(Collection<ParMaterias> parMateriasCollection) {
        this.parMateriasCollection = parMateriasCollection;
    }
    
}
