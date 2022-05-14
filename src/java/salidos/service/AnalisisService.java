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
import salidos.dao.TransaccionFacade;
import salidos.dao.ProductoFacade;
import salidos.dto.AnalisisDTO;
import salidos.dto.TransaccionDTO;
import salidos.dto.ProductoDTO;
import salidos.entity.Analisis;
import salidos.entity.Transaccion;
import salidos.entity.Producto;

/**
 *
 * @author José Manuel Gil Rodríguez
 */
@Stateless
public class AnalisisService {
    
    @EJB AnalisisFacade analisisFacade;
    @EJB TransaccionFacade transaccionFacade;
    @EJB ProductoFacade productoFacade;
    
    private List<AnalisisDTO> listaAnalisisEntityToDTO (List<Analisis> lista) {
        List<AnalisisDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Analisis analisis:lista) {
                listaDTO.add(analisis.toDTO());
            }
        }
        return listaDTO;
    }
    
    private List<TransaccionDTO> listaTransaccionEntityToDTO (List<Transaccion> lista) {
        List<TransaccionDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Transaccion transaccion:lista) {
                listaDTO.add(transaccion.toDTO());
            }
        }
        return listaDTO;
    }
    
    private List<ProductoDTO> listaProductoEntityToDTO (List<Producto> lista) {
        List<ProductoDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Producto producto:lista) {
                listaDTO.add(producto.toDTO());
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
        return this.listaAnalisisEntityToDTO(listaAnalisis);
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
    
    public void borrarAnalisis(int id) {
        Analisis analisis = this.analisisFacade.find(id);
        
        this.analisisFacade.remove(analisis);
    }
    
    public void modificarInforme(int id, String descripcion, int tabla, int columna, int orden) {
        Analisis analisis = this.analisisFacade.find(id);
        
        this.rellenarAnalisis(analisis, descripcion, tabla, columna, orden);
        
        this.analisisFacade.edit(analisis);
    }
    
    public AnalisisDTO buscarAnalisis(int id) {
        Analisis analisis = this.analisisFacade.find(id);
        return analisis.toDTO();
    }
    
    public List<TransaccionDTO> obtenerProductosVendidosCompradosPersonas(int columna, int orden) {
        List<Transaccion> transacciones = this.transaccionFacade.findByTipoInOrder(columna, orden);
        return this.listaTransaccionEntityToDTO(transacciones);
    }
    
    public List<ProductoDTO> obtenerProductosPorColumna(int columna, int orden) {
        List<Producto> productos = this.productoFacade.findProductsByColumnInOrder(columna, orden);
        return this.listaProductoEntityToDTO(productos);
    }
    
}
