/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author gil
 */
@Embeddable
public class TransaccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "producto_id_producto")
    private int productoIdProducto;
    @Basic(optional = false)
    @Column(name = "persona_id_persona")
    private int personaIdPersona;

    public TransaccionPK() {
    }

    public TransaccionPK(int productoIdProducto, int personaIdPersona) {
        this.productoIdProducto = productoIdProducto;
        this.personaIdPersona = personaIdPersona;
    }

    public int getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(int productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    public int getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productoIdProducto;
        hash += (int) personaIdPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionPK)) {
            return false;
        }
        TransaccionPK other = (TransaccionPK) object;
        if (this.productoIdProducto != other.productoIdProducto) {
            return false;
        }
        if (this.personaIdPersona != other.personaIdPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "salidos.entity.TransaccionPK[ productoIdProducto=" + productoIdProducto + ", personaIdPersona=" + personaIdPersona + " ]";
    }
    
}
