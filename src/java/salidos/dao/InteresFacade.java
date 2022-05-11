/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    
}
