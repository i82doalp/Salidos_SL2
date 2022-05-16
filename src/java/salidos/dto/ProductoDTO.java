/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dto;



/**
 *
 * @author Pablo
 */
public class ProductoDTO {
    
    int idProducto;
    String nombreProducto;
    float precioCompra;
    
    

   
    

    
    

  

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
    
     public float getPrecioCompra() {
        return precioCompra;
    }

   
     
     
    
}
