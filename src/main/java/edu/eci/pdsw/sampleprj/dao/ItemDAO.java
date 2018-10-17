package edu.eci.pdsw.sampleprj.dao;

import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.sql.Date;

public interface ItemDAO {

   public void save(Item it) throws PersistenceException;

   public Item load(int id) throws PersistenceException; //
   
   public List<Item> consultarItems() throws PersistenceException;
   
   public List<Item> consultarItemsDisponibles () throws PersistenceException; //
   
   public long multaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException; //
   
   public long consultarCostoAlquiler(int iditem, int numdias) throws PersistenceException; //
   
   public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException; //
   
   public void registrarItem(Item i) throws PersistenceException; //
   
}
