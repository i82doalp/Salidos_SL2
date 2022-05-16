/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.Date;
import salidos.dao.PersonaFacade;
import salidos.dao.ProductoFacade;
import salidos.dao.TransaccionFacade;
import salidos.dto.PersonaDTO;
import salidos.dto.ProductoDTO;
import salidos.entity.Producto;
import salidos.entity.Persona;
import salidos.entity.Transaccion;
import salidos.entity.TransaccionPK;

/**
 *
 * @author Pablo
 */


@Stateless
public class TransaccionService {
    
    @EJB ProductoFacade productofacade;
    @EJB PersonaFacade personafacade;
    @EJB TransaccionFacade transaccionfacade;
    
    public void nuevaTransaccion(Producto producto,Persona persona){
        
       
        
        Transaccion transaccion = new Transaccion();
        TransaccionPK transaccionpk = new TransaccionPK(producto.getIdProducto(),persona.getIdPersona());
        
        transaccion.setProducto(producto);
        transaccion.setPersona(persona);
        transaccion.setTipo("venta");
        transaccion.setFechaTransaccion(new Date());
        transaccion.setTransaccionPK(transaccionpk);
        
        this.transaccionfacade.create(transaccion);
        
        
    }
    
    
    
}
