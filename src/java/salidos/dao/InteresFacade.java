/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import salidos.entity.Interes;

/**
 *
 * @author gil
 */
@jakarta.ejb.Stateless
public class InteresFacade extends AbstractFacade<Interes> {

    @PersistenceContext(unitName = "salidosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InteresFacade() {
        super(Interes.class);
    }
    
    public Interes buscarPorNombre(String nombre){
        
        Query q = this.em.createNamedQuery("Interes.findByNombre");
        q.setParameter("nombre", nombre);
        
        List<Interes> i = q.getResultList();
        
        if(i== null || i.isEmpty()){
            return null;
        }else{
            return i.get(0);
        }
        
    }
    
    public Interes buscarPorId(int id){
        
        Query q = this.em.createNamedQuery("Interes.findByIdInteres");
        q.setParameter("idInteres",id);
        
        List<Interes> interes = q.getResultList();
        
        if(interes == null || interes.isEmpty()){
            return null;
        }else{
            return interes.get(0);
        }
        
    }
    
}
