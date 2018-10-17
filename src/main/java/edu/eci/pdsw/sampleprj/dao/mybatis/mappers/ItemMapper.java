package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Item;
import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("id") int id);
    
    public void insertarItem(@Param("item") Item it);
    
    public List<Item> consultarItemsDisponibles(); 

    public long multaAlquiler(@Param("iditem") int iditem, @Param("fechaDevolucion") Date fechaDevolucion);
    
    public long consultarCostoAlquiler(@Param("iditem") int iditem, @Param("numdias") int numdias);
    public void actualizarTarifaItem(@Param("id")  int id, @Param("tarifa")long tarifa);
}
