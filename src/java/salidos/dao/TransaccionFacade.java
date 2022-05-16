/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import salidos.entity.Transaccion;

/**
 *
 * @author gil
 */
@jakarta.ejb.Stateless
public class TransaccionFacade extends AbstractFacade<Transaccion> {

    @PersistenceContext(unitName = "salidosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionFacade() {
        super(Transaccion.class);
    }
    
    public List <Transaccion> findByTipoInOrder(int columna, int orden) {
        List <Transaccion> list = null;
        
        if (columna == 0) {
            if (orden == 0) {
                Query q = this.em.createQuery("SELECT t FROM Transaccion t WHERE t.tipo = 'venta' ORDER BY t.precioVenta ASC");
                list = q.getResultList();
            } else {
                Query q =  this.em.createQuery("SELECT t FROM Transaccion t WHERE t.tipo = 'venta' ORDER BY t.precioVenta DESC");
                list = q.getResultList();
            }
        } else {
            if (orden == 0) {
                Query q = this.em.createQuery("SELECT t FROM Transaccion t WHERE t.tipo = 'compra' ORDER BY t.precioVenta ASC");
                list = q.getResultList();
            } else {
                Query q =  this.em.createQuery("SELECT t FROM Transaccion t WHERE t.tipo = 'compra' ORDER BY t.precioVenta DESC");
                list = q.getResultList();
            }
        }
        
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
    
}
