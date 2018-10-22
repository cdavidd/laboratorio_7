/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.view;


import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cdavi_000
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "registroClienteBean")
@SessionScoped
public class RegistroClienteBean extends BasePageBean{
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    @Inject
    ServiciosAlquiler serviciosAlquiler;
    
    public List<Cliente> getData() throws Exception{
        try{
            return serviciosAlquiler.consultarClientes();
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        }        
    }
    
    public void addCliente(String nombre, long documento, String telefono, String direccion, String email) throws ExcepcionServiciosAlquiler{
        try{
            Cliente cl= new Cliente(nombre, documento, telefono, direccion, email);
            serviciosAlquiler.registrarCliente(cl);
        }catch(ExcepcionServiciosAlquiler ex){
            throw ex;
        }
    }
    
}
