/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gil
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByProductoIdProducto", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.productoIdProducto = :productoIdProducto"),
    @NamedQuery(name = "Transaccion.findByPersonaIdPersona", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.personaIdPersona = :personaIdPersona"),
    @NamedQuery(name = "Transaccion.findByFechaTransaccion", query = "SELECT t FROM Transaccion t WHERE t.fechaTransaccion = :fechaTransaccion"),
    @NamedQuery(name = "Transaccion.findByPrecioVenta", query = "SELECT t FROM Transaccion t WHERE t.precioVenta = :precioVenta"),
    @NamedQuery(name = "Transaccion.findByTipo", query = "SELECT t FROM Transaccion t WHERE t.tipo = :tipo")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionPK transaccionPK;
    @Column(name = "fecha_transaccion")
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_venta")
    private Float precioVenta;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "persona_id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "producto_id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Transaccion() {
    }

    public Transaccion(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Transaccion(int productoIdProducto, int personaIdPersona) {
        this.transaccionPK = new TransaccionPK(productoIdProducto, personaIdPersona);
    }

    public TransaccionPK getTransaccionPK() {
        return transaccionPK;
    }

    public void setTransaccionPK(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionPK != null ? transaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.transaccionPK == null && other.transaccionPK != null) || (this.transaccionPK != null && !this.transaccionPK.equals(other.transaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "salidos.entity.Transaccion[ transaccionPK=" + transaccionPK + " ]";
    }
    
}
