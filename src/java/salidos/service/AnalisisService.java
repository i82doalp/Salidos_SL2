/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import salidos.dao.AnalisisFacade;
import salidos.dto.AnalisisDTO;
import salidos.entity.Analisis;

/**
 *
 * @author José Manuel Gil Rodríguez
 */
@Stateless
public class AnalisisService {
    
    @EJB AnalisisFacade analisisFacade;
    
    private List<AnalisisDTO> listaEntityToDTO (List<Analisis> lista) {
        List<AnalisisDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Analisis analisis:lista) {
                listaDTO.add(analisis.toDTO());
            }
        }
        return listaDTO;
    }
    
    public List<AnalisisDTO> listarAnalisis () {
        List<Analisis> listaAnalisis = this.analisisFacade.findAll();
        return this.listaEntityToDTO(listaAnalisis);
    }
    
}
