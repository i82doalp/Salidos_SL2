/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import salidos.dao.PersonaFacade;
import salidos.dto.PersonaDTO;
import salidos.entity.Persona;

/**
 *
 * @author gil
 */
@Stateless
public class PersonaService {
    
    @EJB PersonaFacade personaFacade;
    
    public PersonaDTO comprobarCredenciales (String email, String pass) {
        Persona persona = this.personaFacade.comprobarUsuario(email, pass);
        if (persona == null) {
            return null;
        } else {
            return persona.toDTO();
        }
    }
}
