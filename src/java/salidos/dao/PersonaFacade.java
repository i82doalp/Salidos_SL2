/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import salidos.entity.Persona;

/**
 *
 * @author José Manuel Gil Rodríguez (comprobarUsuario)
 */
@jakarta.ejb.Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "salidosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public Persona comprobarUsuario (String email, String pass) {
        Query q = this.em.createQuery("SELECT p FROM Persona p WHERE p.email = :email AND p.password = :password");
        q.setParameter("email", email);
        q.setParameter("password", pass);
        List<Persona> list = q.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
    
    public Persona findByEmail (String email) {
        Query q = this.em.createQuery("SELECT p FROM Persona p WHERE p.email = :email");
        q.setParameter("email", email);
        
        List<Persona> list = q.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
    
    public void eliminar (Persona persona) {
        
        
        Query query = em.createQuery(
        "DELETE FROM Persona-interes p WHERE persona_id_persona = :id");
        int deleted=-1;
        deleted = query.setParameter("id", persona.getIdPersona()).executeUpdate();
        
        if(deleted!=-1){
                query = em.createQuery(
            "DELETE FROM Persona p WHERE id_persona = :id");
            query.setParameter("id", persona.getIdPersona());
        
        
        
        
    }
    }
    
}
