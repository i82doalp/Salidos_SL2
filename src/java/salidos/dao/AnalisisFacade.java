/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import salidos.entity.Analisis;

/**
 *
 * @author gil
 */
@jakarta.ejb.Stateless
public class AnalisisFacade extends AbstractFacade<Analisis> {

    @PersistenceContext(unitName = "salidosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnalisisFacade() {
        super(Analisis.class);
    }
    
}
