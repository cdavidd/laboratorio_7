/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luis
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "registroAlquilerBean")
@SessionScoped
public class RegistroAlquilerBean extends BasePageBean{
    
    @ManagedProperty(value = "#{param.documento}")
    private Long documento;
    
    @Inject
    ServiciosAlquiler serviciosAlquiler;
    
    public List<ItemRentado> getData() throws Exception {
        try{
            return serviciosAlquiler.consultarItemsCliente(documento);
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        }
    }
    
    public void registroAlquiler(Date date, int idItem, int numdias) throws ExcepcionServiciosAlquiler{
        try{
            Item item =   serviciosAlquiler.consultarItem(idItem);
            serviciosAlquiler.registrarAlquilerCliente(date, documento, item, numdias);
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        } 
    }
    
    public long getDocumento(){
        return documento;
    }
    
    public void setDocumento(Long documento){
        this.documento= documento;
    }
}
