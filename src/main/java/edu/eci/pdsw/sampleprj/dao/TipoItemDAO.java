package edu.eci.pdsw.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.TipoItem;
import java.util.List;

public interface TipoItemDAO {
    public void save(String it) throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;
    
    public TipoItem consultarTipoItem(int id) throws PersistenceException; //
    
    public List<TipoItem> consultarTiposItem() throws PersistenceException; //
           

}
