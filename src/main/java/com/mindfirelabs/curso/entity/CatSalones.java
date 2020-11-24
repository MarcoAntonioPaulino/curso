package com.mindfirelabs.curso.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cat_salones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatSalones.findAll", query = "SELECT c FROM CatSalones c WHERE c.fechaElimino IS NULL"),
    @NamedQuery(name = "CatSalones.findById", query = "SELECT c FROM CatSalones c WHERE c.id = :id"),
    @NamedQuery(name = "CatSalones.findByFechaRegistro", query = "SELECT c FROM CatSalones c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "CatSalones.findByFechaModifico", query = "SELECT c FROM CatSalones c WHERE c.fechaModifico = :fechaModifico"),
    @NamedQuery(name = "CatSalones.findByFechaElimino", query = "SELECT c FROM CatSalones c WHERE c.fechaElimino = :fechaElimino"),
    @NamedQuery(name = "CatSalones.findByIdUsuarioRegistro", query = "SELECT c FROM CatSalones c WHERE c.idUsuarioRegistro = :idUsuarioRegistro"),
    @NamedQuery(name = "CatSalones.findByIdUsuarioModifico", query = "SELECT c FROM CatSalones c WHERE c.idUsuarioModifico = :idUsuarioModifico"),
    @NamedQuery(name = "CatSalones.findByIdUsuarioElimino", query = "SELECT c FROM CatSalones c WHERE c.idUsuarioElimino = :idUsuarioElimino"),
    @NamedQuery(name = "CatSalones.findByNombre", query = "SELECT c FROM CatSalones c WHERE c.nombre LIKE :nombre AND c.fechaElimino IS NULL"),
    @NamedQuery(name = "CatSalones.findByDescripcion", query = "SELECT c FROM CatSalones c WHERE c.descripcion LIKE :descripcion AND c.fechaElimino IS NULL")})
public class CatSalones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_modifico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    @Column(name = "fecha_elimino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElimino;
    @Column(name = "id_usuario_registro")
    private Integer idUsuarioRegistro;
    @Column(name = "id_usuario_modifico")
    private Integer idUsuarioModifico;
    @Column(name = "id_usuario_elimino")
    private Integer idUsuarioElimino;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public CatSalones() {
    }

    public CatSalones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModifico() {
        return fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public Date getFechaElimino() {
        return fechaElimino;
    }

    public void setFechaElimino(Date fechaElimino) {
        this.fechaElimino = fechaElimino;
    }

    public Integer getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Integer idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Integer getIdUsuarioModifico() {
        return idUsuarioModifico;
    }

    public void setIdUsuarioModifico(Integer idUsuarioModifico) {
        this.idUsuarioModifico = idUsuarioModifico;
    }

    public Integer getIdUsuarioElimino() {
        return idUsuarioElimino;
    }

    public void setIdUsuarioElimino(Integer idUsuarioElimino) {
        this.idUsuarioElimino = idUsuarioElimino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatSalones)) {
            return false;
        }
        CatSalones other = (CatSalones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mindfirelabs.curso.entity.CatSalones[ id=" + id + " ]";
    }

}
