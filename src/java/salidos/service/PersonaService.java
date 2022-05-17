/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import salidos.dao.InteresFacade;
import salidos.dao.PersonaFacade;
import salidos.dto.PersonaDTO;
import salidos.entity.Interes;
import salidos.entity.Persona;

/**
 *
 * @author Cristian Alberto Sanchez
 */
@Stateless
public class PersonaService {
    
    @EJB PersonaFacade personaFacade;
    @EJB InteresFacade interesFacade;
    
   
    public PersonaDTO comprobarCredenciales (String email, String pass) {
        Persona persona = this.personaFacade.comprobarUsuario(email, pass);
        if (persona == null) {
            return null;
        } else {
            return persona.toDTO();
        }
    }
    
    public PersonaDTO encontrarPorEmail (String email) {
        Persona persona = this.personaFacade.findByEmail(email);
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
    
    

     public PersonaDTO registrarUsuario (Persona persona) {
       this.personaFacade.create(persona);
       Persona pers = this.personaFacade.comprobarUsuario(persona.getEmail(), persona.getPassword());

        if (pers == null) {
            return null;
        } else {
            return pers.toDTO();
        }
    }
     
      
    private List<PersonaDTO> listaPersonaEntityToDTO (List<Persona> lista) {
        List<PersonaDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Persona persona:lista) {
                listaDTO.add(persona.toDTO());
            }
        }
        return listaDTO;
    }
     
       
    public List <PersonaDTO> listaPersonas () 
    {
       List <Persona> personas= this.personaFacade.findAll();
       List <PersonaDTO> personasDTO=listaPersonaEntityToDTO(personas);
       
       if(personasDTO!=null)
       {
           return personasDTO;
       }
       else
       {
           return null;
       }
               
    }
    
    public List <Persona> listaPersonasEntity () 
    {
       List <Persona> personas= this.personaFacade.findAll();
       
       
       if(personas!=null)
       {
           return personas;
       }
       else
       {
           return null;
       }
               
    }

    
    public PersonaDTO encontrarPorId(int id) 
    {
       
       PersonaDTO personaDTO= personaFacade.find(id).toDTO();
       
       if(personaDTO!=null)
       {
           return personaDTO;
       }
       else
       {
           return null;
       }
               
    }
    
    
    public void deletePersona(int id) 
    {
       Persona persona= personaFacade.find(id);

       
       persona.setInteresList(null);
       this.personaFacade.eliminar(persona);
       
          
    }
    
    
     private void rellenarPersona (Persona persona ,String email, String pass, String Nombre, String Apellidos,
                  String domicilio, String ciudad, Date fecha_nacimiento, char sexo,
                  String rol, List<Interes> interes_persona ) {
        persona.setEmail(email);
        persona.setPassword(pass);
        persona.setNombre(Nombre);
        persona.setApellidos(Apellidos);
        persona.setDomicilio(domicilio);
        persona.setCiudad(ciudad);
        persona.setFNacimiento(fecha_nacimiento);
        persona.setSexo(sexo);
        persona.setRol(rol);
        persona.setInteresList(interes_persona);
    }
     
     
    
     public void modificarPersona(int id ,String email, String pass, String Nombre, String Apellidos,
                  String domicilio, String ciudad, Date fecha_nacimiento, char sexo,
                  String rol, List<Interes> interes_persona ) 
     {
        Persona persona = this.personaFacade.find(id);
        
        this.rellenarPersona(persona,email,  pass,  Nombre,  Apellidos,
                   domicilio,  ciudad,  fecha_nacimiento,  sexo,
                   rol, interes_persona);

        
        this.personaFacade.edit(persona);
    }
    
    public List<Interes> retornarListaIntereses(String [] intereses) 
    {
        List<Interes> lista_intereses = new ArrayList<Interes>();
        
       for(int i =0; i<intereses.length;i++)
       {
           lista_intereses.add(interesFacade.find(Integer.parseInt(intereses[i])));
       }
           
       return lista_intereses;
       
       

    }

}
