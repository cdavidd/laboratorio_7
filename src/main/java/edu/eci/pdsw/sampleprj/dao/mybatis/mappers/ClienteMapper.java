package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli") int id);  //--
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("id") int id, 
            @Param("idit") int idit, 
            @Param("fechaInicio") Date fechainicio,
            @Param("fechaFin") Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes(); // --
    
    public void agregarCliente(@Param("cliente") Cliente cli); // --
    
    public void registrarAlquilerCliente(@Param("date") Date date,@Param("docu") long docu,@Param("item") Item item,@Param("numdias") int numdias); // --
    
    public void registrarCliente(@Param("c") Cliente c); // --
    
    public void vetarCliente(@Param("ducu") long docu,@Param("estado") boolean estado); // --
    
    public List<ItemRentado> consultarItemsCliente(@Param("idcl") long idcliente);
    
}
