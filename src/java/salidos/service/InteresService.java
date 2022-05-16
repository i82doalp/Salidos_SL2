/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salidos.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import salidos.dao.InteresFacade;
import salidos.entity.Interes;

/**
 *
 * @author Pablo
 */


@Stateless
public class InteresService {
    
    
    @EJB InteresFacade interesfacade;
    
    public List<Interes> getIntereses (String[] i){
        
        List<Interes> intereses = new ArrayList<Interes>();
        
        for(int f=0;f<i.length;f++){
            intereses.add(this.interesfacade.find(i[f]));
        }
        
        
        return intereses;
        
    }
    
    
}
