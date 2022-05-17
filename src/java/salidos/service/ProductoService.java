/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import salidos.dao.InteresFacade;
import salidos.dao.ProductoFacade;
import salidos.dto.ProductoDTO;
import salidos.entity.Interes;
import salidos.entity.Producto;

/**
 *
 * @author Pablo
 */
@Stateless
public class ProductoService {
    
    @EJB ProductoFacade productofacade;
    @EJB InteresFacade interesfacade;
    
    
    
    private List<ProductoDTO> listaEntityADTO(List<Producto> lista){
        
        List<ProductoDTO> listaDTO = new ArrayList<ProductoDTO>();
        
        if(lista != null){
            listaDTO = new ArrayList<>();
            for(Producto producto : lista){
                listaDTO.add(producto.toDTO());
            }
        }
        return listaDTO;
    }
    
    
    public List<ProductoDTO> getVentas (int idPersona){
        
        
        List<Producto> ventas = this.productofacade.getVentas(idPersona);
        
        if(ventas == null){
            return null;
        }else{
            return this.listaEntityADTO(ventas);
        }
               
        
    } 
    
    public List<ProductoDTO> getAllProductos (){
        
        
        List<Producto> productos = this.productofacade.findAll();
        
        if(productos == null){
            return null;
        }else{
            return this.listaEntityADTO(productos);
        }       
        
    }
    
    
    

    
    
    public void productoModificado(int id,String nombre,float precioS,String descripcion,List<Interes> intereses){
            
        Producto p = this.productofacade.buscarPorId(id);
        
        rellenarProducto(p,id,nombre,precioS,descripcion,intereses);
        
        this.productofacade.edit(p);
     
    }
   
   
    
    public void rellenarProducto(Producto producto,String nombre,float precioS,String descripcion,List<Interes> intereses){
        
        producto.setTitulo(nombre);
        producto.setPrecioSalida(precioS);
        producto.setPrecioCompra(precioS);
        producto.setDescripcion(descripcion);
        producto.setPrecioCompra(0);
        producto.setInteresList(intereses);     
        
    }
    
    public void rellenarProducto(Producto producto,int id, String nombre,float precioS,String descripcion,List<Interes> intereses){
        
        List<Interes> nuevos_intereses = new ArrayList<Interes>();
        
        if(!nombre.equals(producto.getTitulo())){ 
            producto.setTitulo(nombre); 
        }
        if(precioS != producto.getPrecioSalida()){
            producto.setPrecioSalida(precioS);
        }
        if(!descripcion.equals(producto.getDescripcion())){ 
            producto.setDescripcion(descripcion);
        }
        
        for(int i = 0;i<producto.getInteresList().size();i++){
           if(producto.getInteresList().get(i).getIdInteres() != intereses.get(i).getIdInteres()){
               nuevos_intereses.add(intereses.get(i));
           }
        }
        
        producto.setPrecioCompra(0);
        producto.setInteresList(nuevos_intereses);     
        
    }
    
    
    
    
    public Producto nuevaVenta(String nombre,float precioS,String descripcion,List<Interes> intereses){
        
       Producto producto = new Producto();
       rellenarProducto(producto,nombre,precioS,descripcion,intereses);
       this.productofacade.create(producto);
       
       return producto;
       
    }
    
    
    
    public Producto buscarPorNombre(String nombre){
        
        Producto p = this.productofacade.buscarPorNombre(nombre);
        
        return p;
        
    }
    
    public Producto buscarPorId (int id){
        
        Producto p = this.productofacade.find(id);
        
        return p;
        
    }
    
    
    public void borrarProducto(int id){
        
        Producto producto = this.productofacade.find(id);
        
        int nfilas = this.productofacade.borrarProducto(producto.getIdProducto());
        
        System.out.println(nfilas);
        
    }
    
    
    
}
