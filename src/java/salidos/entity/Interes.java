/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gil
 */
@Entity
@Table(name = "interes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interes.findAll", query = "SELECT i FROM Interes i"),
    @NamedQuery(name = "Interes.findByIdInteres", query = "SELECT i FROM Interes i WHERE i.idInteres = :idInteres"),
    @NamedQuery(name = "Interes.findByNombre", query = "SELECT i FROM Interes i WHERE i.nombre = :nombre")})
public class Interes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_interes")
    private Integer idInteres;
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "Persona-interes", joinColumns = {
        @JoinColumn(name = "interes_id_interes", referencedColumnName = "id_interes")}, inverseJoinColumns = {
        @JoinColumn(name = "persona_id_persona", referencedColumnName = "id_persona")})
    @ManyToMany
    private List<Persona> personaList;
    @JoinTable(name = "Producto-interes", joinColumns = {
        @JoinColumn(name = "interes_id_interes", referencedColumnName = "id_interes")}, inverseJoinColumns = {
        @JoinColumn(name = "producto_id_producto", referencedColumnName = "id_producto")})
    @ManyToMany
    private List<Producto> productoList;

    public Interes() {
    }

    public Interes(Integer idInteres) {
        this.idInteres = idInteres;
    }

    public Integer getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Integer idInteres) {
        this.idInteres = idInteres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInteres != null ? idInteres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interes)) {
            return false;
        }
        Interes other = (Interes) object;
        if ((this.idInteres == null && other.idInteres != null) || (this.idInteres != null && !this.idInteres.equals(other.idInteres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "salidos.entity.Interes[ idInteres=" + idInteres + " ]";
    }
    
}
