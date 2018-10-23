package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
//import edu.eci.pdsw.sampleprj.dao.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   
   @Inject
   private ClienteDAO clienteDAO;
   
   @Inject
   private TipoItemDAO tipoItemDAO;
  
   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       try {
    	   return (int) itemDAO.load(itemId).getTarifaxDia();
       }catch (UnsupportedOperationException e){
    	   throw new UnsupportedOperationException("no existe."+itemId,e);
       }
	  
   }

   
   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
       try {
    	   return clienteDAO.load((int) docu);
       }catch(PersistenceException e) {
    	   throw new ExcepcionServiciosAlquiler("Error en el cliente."+docu,e);   
       }
	   
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.consultarItemsCliente(idcliente);
	   }catch(PersistenceException e) {
		   throw new ExcepcionServiciosAlquiler("no se pudo consultar items cliente."+idcliente,e);   
	   }
       
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.consultarClientes();
	   }catch(PersistenceException e) {
		   throw new ExcepcionServiciosAlquiler("no ser pudo consultar clientes.",e);
	   }
	   
       
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
          
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() {
       try{
           return itemDAO.consultarItemsDisponibles();
       }catch(UnsupportedOperationException ex){
           throw new UnsupportedOperationException("Error al consultar items ",ex);
       }
       
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
       try{
           return itemDAO.multaAlquiler(iditem,fechaDevolucion);
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al consultar multa alquiler "+iditem,ex);
       }
       
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return tipoItemDAO.consultarTipoItem(id);
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al consultar tipo item "+id,ex);
       }
       
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       try{
           return tipoItemDAO.consultarTiposItem();
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al consultar los tipos Items ");
       } 
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
       try{
           clienteDAO.registrarAlquilerCliente(date, docu, item, numdias);
       }catch(PersistenceException ex){
           throw new UnsupportedOperationException("No se puede registrar el alquiler "+item,ex);
       }
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
       try{
           clienteDAO.registrarCliente(c);
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al registrar Cliente "+c,ex);
       }
       
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       try{
           return itemDAO.consultarCostoAlquiler(iditem, numdias);
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al consultar costo alguiler "+iditem);
       }
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       try {
           itemDAO.actualizarTarifaItem(id, tarifa);
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al actuaizar tarifa "+id);
       }
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
       try {
           itemDAO.registrarItem(i);
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al registrar item "+i); //To change body of generated methods, choose Tools | Templates.
       }
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       try{
           clienteDAO.vetarCliente(docu, estado);
       }catch(PersistenceException ex){
           throw new ExcepcionServiciosAlquiler("Error al vetar al cliente "+docu); //To change body of generated methods, choose Tools | Templates.
       }
       
   }
}
