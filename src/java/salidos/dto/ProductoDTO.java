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

    private int idProducto;
    private String nombreProducto;
    private float precioCompra;
    private float precioSalida;
    private String descripcion;
    
<<<<<<< HEAD
    int idProducto;
    String nombreProducto;
    float precioCompra;
    
    

   
    

    
    
=======
    /**
     * @return the precioSalida
     */
    public float getPrecioSalida() {
        return precioSalida;
    }
>>>>>>> 59dfcad48bacdc183a6d725c843028ef9a67a16c

    /**
     * @param precioSalida the precioSalida to set
     */
    public void setPrecioSalida(float precioSalida) {
        this.precioSalida = precioSalida;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
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
