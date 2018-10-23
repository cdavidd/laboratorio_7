/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.view;


import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


/**
 *
 * @author Luis
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "registroAlquilerBean")
@RequestScoped
public class RegistroAlquilerBean extends BasePageBean{
    
    
    @ManagedProperty(value = "#{param.documento}")
    
    
    private long documento;
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    @Inject
    ServiciosAlquiler serviciosAlquiler;
    
    public List<ItemRentado> getData() throws ExcepcionServiciosAlquiler {
        try{
            
            return serviciosAlquiler.consultarItemsCliente(documento);
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        }
    }
    
    public void registroAlquiler(int idItem, int numdias) throws ExcepcionServiciosAlquiler{
        try{
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            Item item =   serviciosAlquiler.consultarItem(idItem);

            serviciosAlquiler.registrarAlquilerCliente(date, documento, item, numdias);
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        } 
    }
    
    public long getDocumento(){
        return documento;
    }
    
    public void setDocumento(long documento){
        this.documento= documento;
    }
}
