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
    
    private void rellenarAnalisis (Analisis analisis, String descripcion, int tabla, int columna, int orden) {
        analisis.setDescripcion(descripcion);
        analisis.setTabla(tabla);
        analisis.setColumna(columna);
        analisis.setOrden(orden);
    }
    
    public List<AnalisisDTO> listarAnalisis () {
        List<Analisis> listaAnalisis = this.analisisFacade.findAll();
        return this.listaEntityToDTO(listaAnalisis);
    }
    
    public String generarDescripcion(int tabla, int columna, int orden){
        String strTabla, strColumna, strOrden, descripcion;
        
        if (tabla == 0)
            strTabla = "Personas";
        else
            strTabla = "Productos";
        
        strColumna = switch (columna) {
            case 1 -> "Productos comprados";
            case 2 -> "Precio de salida";
            case 3 -> "Precio de compra";
            case 4 -> "Estado";
            default -> "Productos vendidos";
        };
        
        if (orden == 0)
            strOrden = "Ascendente";
        else
            strOrden = "Descendente";
        
        descripcion = "Informe sobre " + strTabla + " por " + strColumna + " en orden " + strOrden;
        
        return descripcion;
    }
    
    public void crearInforme (String descripcion, int tabla, int columna, int orden) {
        Analisis analisis = new Analisis();
        
        this.rellenarAnalisis(analisis, descripcion, tabla, columna, orden);
        
        this.analisisFacade.create(analisis);
    }
    
}
