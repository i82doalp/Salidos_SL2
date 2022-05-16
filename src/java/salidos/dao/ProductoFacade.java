/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import salidos.entity.Producto;

/**
 *
 * @author gil
 */
@jakarta.ejb.Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "salidosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    public List<Producto> getVentas(int idpersona){
        
        Query q = this.em.createQuery("Select pr from Producto pr join Transaccion t "
                + "where t.producto.idProducto = pr.idProducto and "
                + "t.persona.idPersona = :id and t.tipo = 'venta'");
        
        q.setParameter("id", idpersona);
        
        List<Producto> ventas = q.getResultList();
        
        
        if(ventas == null || ventas.isEmpty()){
            return null;
        }else{
            return ventas;
        }
        
    }
    
    
    public Producto buscarPorNombre(String nombre){
        
        
        Query q = this.em.createNamedQuery("findByTitulo");
        
        q.setParameter("titulo",nombre);
        
        List<Producto> product = q.getResultList();
        
        if(product == null || product.isEmpty()){
            return null;
        }else{
            return product.get(0);
        }
        
        
    }
    
    
}
