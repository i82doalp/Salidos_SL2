/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.dto;

import java.util.Date;
import salidos.entity.Persona;

/**
 *
 * @author José Manuel Gil Rodríguez
 */
public class PersonaDTO {
    private Integer idPersona;
    private String email;
    private String password;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String ciudad;
    private Date fNacimiento;
    private Character sexo;
    private float monedero;
    private String rol;
    
    public PersonaDTO() {
    }
    
    /**
     * @return the idPersona
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the fNacimiento
     */
    public Date getfNacimiento() {
        return fNacimiento;
    }

    /**
     * @param fNacimiento the fNacimiento to set
     */
    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    /**
     * @return the sexo
     */
    public Character getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the monedero
     */
    public float getMonedero() {
        return monedero;
    }

    /**
     * @param monedero the monedero to set
     */
    public void setMonedero(float monedero) {
        this.monedero = monedero;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    public Persona toEntity() {
        Persona entity = new Persona();
    
        entity.setIdPersona(idPersona);
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setNombre(nombre);
        entity.setApellidos(apellidos);
        entity.setDomicilio(domicilio);
        entity.setCiudad(ciudad);
        entity.setFNacimiento(fNacimiento);
        entity.setSexo(sexo);
        entity.setMonedero(monedero);
        entity.setRol(rol);
        
        return entity;
    }
}
