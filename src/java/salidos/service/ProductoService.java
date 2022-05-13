/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import salidos.dao.ProductoFacade;
import salidos.dao.TransaccionFacade;
import salidos.dto.ProductoDTO;
import salidos.entity.Producto;

/**
 *
 * @author Pablo
 */
@Stateless
public class ProductoService {
    
    @EJB ProductoFacade productofacade;
    
    
    
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
    
}
