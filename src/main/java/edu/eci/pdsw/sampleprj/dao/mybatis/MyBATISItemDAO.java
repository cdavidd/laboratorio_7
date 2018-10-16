package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
//import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MyBATISItemDAO implements ItemDAO{

  @Inject
  private ItemMapper itemMapper;    

  @Override
  public void save(Item it) throws PersistenceException{
  try{
      itemMapper.insertarItem(it);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el item "+it.toString(),e);
  }        

  }

  @Override
  public Item load(int id) throws PersistenceException {
  try{
      return itemMapper.consultarItem(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el item "+id,e);
  }


  }
  
  @Override
  public List<Item> consultarItems() throws PersistenceException {
  	try{
  		return itemMapper.consultarItems();
  		}
  	catch(org.apache.ibatis.exceptions.PersistenceException e){
  		throw new PersistenceException("Error al consultar el items ",e);
  		}
  	}

    @Override
    public List<Item> consultarItemsDisponibles() throws PersistenceException {
        try{
  		return itemMapper.consultarItemsDisponibles();
  		}
  	catch(org.apache.ibatis.exceptions.PersistenceException e){
  		throw new PersistenceException("Error al consultar ItemsDisponibles ",e);
  		}
  	}
    

    @Override
    public long multaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarItem(Item i) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

  

