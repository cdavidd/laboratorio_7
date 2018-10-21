/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luis
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "RegistroAlquilerBean")
@SessionScoped
public class RegistroAlquilerBean extends BasePageBean{
    @Inject
    ServiciosAlquiler serviciosAlquiler;
    
    public List<Cliente> getData() throws Exception{
        try{
            return serviciosAlquiler.consultarClientes();
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        }        
    }
    
    public void registroAlquiler(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler{
        try{
            serviciosAlquiler.registrarAlquilerCliente(date, docu, item, numdias);
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        } 
    }
}
