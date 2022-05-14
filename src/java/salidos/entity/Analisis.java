/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import salidos.dto.AnalisisDTO;

/**
 *
 * @author gil
 */
@Entity
@Table(name = "analisis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analisis.findAll", query = "SELECT a FROM Analisis a"),
    @NamedQuery(name = "Analisis.findById", query = "SELECT a FROM Analisis a WHERE a.id = :id"),
    @NamedQuery(name = "Analisis.findByDescripcion", query = "SELECT a FROM Analisis a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Analisis.findByTabla", query = "SELECT a FROM Analisis a WHERE a.tabla = :tabla"),
    @NamedQuery(name = "Analisis.findByColumna", query = "SELECT a FROM Analisis a WHERE a.columna = :columna"),
    @NamedQuery(name = "Analisis.findByOrden", query = "SELECT a FROM Analisis a WHERE a.orden = :orden")})
public class Analisis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tabla")
    private int tabla;
    @Basic(optional = false)
    @Column(name = "columna")
    private int columna;
    @Basic(optional = false)
    @Column(name = "orden")
    private int orden;

    public Analisis() {
    }

    public Analisis(Integer id) {
        this.id = id;
    }

    public Analisis(Integer id, String descripcion, int tabla, int columna, int orden) {
        this.id = id;
        this.descripcion = descripcion;
        this.tabla = tabla;
        this.columna = columna;
        this.orden = orden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTabla() {
        return tabla;
    }

    public void setTabla(int tabla) {
        this.tabla = tabla;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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
        if (!(object instanceof Analisis)) {
            return false;
        }
        Analisis other = (Analisis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "salidos.entity.Analisis[ id=" + id + " ]";
    }
    
    public AnalisisDTO toDTO () {
        AnalisisDTO dto = new AnalisisDTO();
        
        dto.setId(id);
        dto.setDescripcion(descripcion);
        dto.setTabla(tabla);
        dto.setColumna(columna);
        dto.setOrden(orden);
        
        return dto;
    }
    
}
