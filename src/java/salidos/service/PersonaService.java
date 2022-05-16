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
 * @author José Manuel Gil Rodríguez
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
    
    
    public Persona DTOaPersona(PersonaDTO personadto){
        
        Persona persona = new Persona();
        
        persona.setNombre(personadto.getNombre());
        persona.setApellidos(personadto.getApellidos());
        persona.setCiudad(personadto.getCiudad());
        persona.setDomicilio(personadto.getDomicilio());
        persona.setEmail(personadto.getEmail());
        persona.setFNacimiento(personadto.getfNacimiento());
        persona.setIdPersona(personadto.getIdPersona());
        persona.setMonedero(personadto.getMonedero());
        persona.setPassword(personadto.getPassword());
        persona.setRol(personadto.getRol());
        persona.setSexo(personadto.getSexo());
        
        return persona;
        
        
        
    }
    
    
}
