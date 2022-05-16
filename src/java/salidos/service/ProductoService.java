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
        
        List<ProductoDTO> listaDTO = null;
        
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
    
    public List<Interes> rellenarIntereses(List<String> intereses){
        
         List<Interes> lista = new ArrayList<>();
        
        for(int i=0;i<intereses.size();i++){
           lista.add(this.interesfacade.buscarPorNombre(intereses.get(i))); 
        }
        
       return lista;
        
    }
    
    public void rellenarProducto(Producto producto,String nombre,float precioS,String descripcion,List<String> intereses){
        
        producto.setTitulo(nombre);
        producto.setPrecioSalida(precioS);
        producto.setDescripcion(descripcion);
        producto.setPrecioCompra(0);
        List<Interes> interesList = rellenarIntereses(intereses);
        producto.setInteresList(interesList);
        
        
        
    }
    
    
    public Producto nuevaVenta(String nombre,float precioS,String descripcion,List<String> intereses){
        
       Producto producto = new Producto();
       rellenarProducto(producto,nombre,precioS,descripcion,intereses);
       this.productofacade.create(producto);
       
       return producto;
       
    }
    
    
    
    public Producto buscarPorNombre(String nombre){
        
        Producto p = this.productofacade.buscarPorNombre(nombre);
        
        return p;
        
    }
    
    
}
